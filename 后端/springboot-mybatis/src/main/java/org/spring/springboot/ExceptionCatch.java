package org.spring.springboot;

import org.spring.springboot.service.Service;

import java.lang.reflect.Method;
import java.util.Collection;

public class ExceptionCatch {
    public static ResultBean exceptionCatch(Service service, String id, Object... args) {
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        Class[] classes = new Class[args.length];
        for (int i = 0; i < args.length; i++) {
            classes[i] = args[i].getClass();
        }
        try {
            Method method = service.getClass().getDeclaredMethod(methodName, classes);
            return ResultBean.success(id, (Collection<?>) method.invoke(service, args));
        } catch (Exception e) {
            if (e.getCause() == null) {
                try{
                    HttpClient.record(e.toString());
                }catch (Exception e1){}
            }
            return ResultBean.error(id, -1, e.getCause().getMessage());
        }
    }
}
