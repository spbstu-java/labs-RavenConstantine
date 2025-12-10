import java.lang.reflect.*;
import java.util.*;

public class ReflectionInvoker {
    private static final Map<Class<?>, Object> paramsMap = new HashMap<>();
    static {
        paramsMap.put(String.class, "Буквы и точка.");
        paramsMap.put(int.class, 3);
        paramsMap.put(Integer.class, 3);
    }

    public static void InvokeProAndPriMethods(Object targetObject) {
        if (targetObject == null)
            return;
        Class<?> targetType = targetObject.getClass();
        Method[] declaredMethods = targetType.getDeclaredMethods();
        for (Method methodHandle : declaredMethods) {
            int modifier = methodHandle.getModifiers();
            if (!Modifier.isPrivate(modifier) && !Modifier.isProtected(modifier) || !methodHandle.isAnnotationPresent(RepeatCount.class)) continue;
            RepeatCount repeatCount = methodHandle.getAnnotation(RepeatCount.class);
            int rCount = repeatCount == null ? 1 : repeatCount.value();
            System.out.println("Метод: " + methodHandle.getName() + "; Модификатор: " + (Modifier.isPrivate(modifier) ? "private" : "protected") + "; Кол-во вызовов: " + rCount);
            boolean accessChanged = false;
            try {
                if (!methodHandle.canAccess(targetObject)) {
                    methodHandle.setAccessible(true);
                    accessChanged = true;
                }
                Object[] args = buildArgsForMethod(methodHandle);
                for (int i = 0; i < rCount; i++) {
                    System.out.print("Invoke " + (i + 1) + "/" + rCount + ": ");
                    try {
                        Object result = methodHandle.invoke(targetObject, args);
                        if (!methodHandle.getReturnType().equals(void.class)) {
                            System.out.println("Return " + (i + 1) + "/" + rCount + ": " + result);
                        }
                    } catch (InvocationTargetException ite) {
                        System.err.println("Exception: " + ite.getTargetException());
                    }
                }
            } catch (IllegalAccessException | IllegalArgumentException e) {
                System.err.println("Ошибка при вызове метода " + methodHandle.getName() + ": " + e.getMessage());
            } finally {
                if (accessChanged) {
                    try {
                        methodHandle.setAccessible(false);
                    } catch (SecurityException ignored) { }
                }
            }
            System.out.println();
        }
    }

    private static Object[] buildArgsForMethod(Method methodHandle) {
        Class<?>[] paramTypes = methodHandle.getParameterTypes();
        if (paramTypes.length == 0)
            return new Object[0];
        Object[] args = new Object[paramTypes.length];
        for (int i = 0; i < paramTypes.length; i++) {
            Object defaultValue = paramsMap.get(paramTypes[i]);
            if (defaultValue == null) {
                System.err.println("Отсутствует значение по умолчанию " + paramTypes[i].getName() + "; Использован null");
            }
            args[i] = defaultValue;
        }
        return args;
    }
}
