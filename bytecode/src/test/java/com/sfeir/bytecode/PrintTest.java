package com.sfeir.bytecode;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.objectweb.asm.AnnotationVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.util.TraceClassVisitor;
import org.testng.annotations.Test;

import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;

/**
 * TODO : explain.me
 * Date: 20/09/12
 * Time: 20:18
 *
 * @author françois LAROCHE
 */
public class PrintTest {

    @Test
    public void displayClass() throws Exception {

        InputStream str = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/sfeir/bytecode/MultiDispatched.class");
        ClassReader reader = new ClassReader(str);
        TraceClassVisitor trace =
                new TraceClassVisitor(new PrintWriter(System.out));
        reader.accept(trace, 0);

    }


    @Test
    public void modifyClass() throws Exception{

        InputStream str = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("com/sfeir/bytecode/MultiDispatched.class");
        ClassReader reader = new ClassReader(str);

        final Multimap<String, String> methods = ArrayListMultimap.create();
        final List<String> multiDispachedMethods = Lists.newArrayList();

        reader.accept(new ClassVisitor(Opcodes.ASM4) {
            @Override
            public MethodVisitor visitMethod(int access, final String name, String desc, String signature,
                                             String[] exceptions) {
                methods.put(name, desc);
                return new MethodVisitor(Opcodes.ASM4) {
                    @Override
                    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
                        if(desc.contains("com/sfeir/bytecode/multidispatch/MultiDispatch")) {
                            multiDispachedMethods.add(name);
                        }
                        return super.visitAnnotation(desc, visible);
                    }
                };
            }
        }, 0);

        Collection<String> keys = ImmutableList.copyOf(methods.keys());

        for(String key : keys) {
            if(!multiDispachedMethods.contains(key)) {
                methods.removeAll(key);
            }
        }

        final ClassWriter writer = new ClassWriter(0) {
        };

        ClassVisitor visitor = new ClassVisitor(Opcodes.ASM4, writer) {
            @Override
            public MethodVisitor visitMethod(int access, final String name, final String desc, String signature,
                                             String[] exceptions) {
                if(multiDispachedMethods.contains(name)) {
                    return new MethodVisitor(Opcodes.ASM4, super.visitMethod(access, name, desc, signature,
                            exceptions)) {
                        @Override
                        public void visitCode() {
                            if("(Ljava/lang/Object;)V".equals(desc)) {
                                visitVarInsn(Opcodes.ALOAD, 1);
                                visitTypeInsn(Opcodes.INSTANCEOF, "java/lang/Integer");
                                Label l1 = new Label();
                                visitJumpInsn(Opcodes.IFEQ, l1);
                                visitVarInsn(Opcodes.ALOAD, 0);
                                visitVarInsn(Opcodes.ALOAD, 1);
                                visitTypeInsn(Opcodes.CHECKCAST, "java/lang/Integer");
                                visitMethodInsn(Opcodes.INVOKEVIRTUAL, "com/sfeir/bytecode/MultiDispatched", name,
                                        "(Ljava/lang/Integer;)V");
                                visitInsn(Opcodes.RETURN);
                                visitLabel(l1);
                            }

                            super.visitCode();

                        }
                    };
                }
                return super.visitMethod(access, name, desc, signature, exceptions);

            }
        } ;

        reader.accept(visitor, 0);

        byte[] result = writer.toByteArray();
        Class<?> myClass = new MyLoader().defineMyClass(result, "com.sfeir.bytecode.MultiDispatched");
        Object instance = myClass.newInstance();
        Object param = new Integer(2);
        Method m = myClass.getMethod("doSomething", Object.class);
        m.invoke(instance, param);
    }

    private static class MyLoader extends ClassLoader {
        Class<?> defineMyClass (byte[] data, String name) {
            return this.defineClass(name, data, 0, data.length);
        }
    }

}
