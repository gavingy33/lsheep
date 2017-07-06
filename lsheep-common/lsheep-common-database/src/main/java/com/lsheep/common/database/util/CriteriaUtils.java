package com.lsheep.common.database.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.lsheep.common.core.utils.StringUtils;

public class CriteriaUtils {

	public static <C, M> void buildEqualToCriteria(C criteria, M model) {
		try {
			Field[] fields = model.getClass().getDeclaredFields();
			for (Field field : fields) {
				field.setAccessible(true);
				Object value = field.get(model);
				if (value == null) {
					continue;
				}
				if (value instanceof String && StringUtils.isEmpty(value)) {
					continue;
				}

				StringBuffer methodName = new StringBuffer();
				methodName.append("and").append(StringUtils.captureName(field.getName())).append("EqualTo");
				Method method = criteria.getClass().getMethod(methodName.toString(), new Class[] { value.getClass() });
				method.invoke(criteria, new Object[] { value });
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("build criteria error");
		}
	}

}
