package test;

import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.joda.time.DateTime;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.text.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BasicUnitTest {


    public void testBeanUtils() throws InvocationTargetException, IllegalAccessException {
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "test");
        map.put("lastName", "testLast");
        map.put("middleName", "testMid");

        MyBean myBean = new MyBean();

        BeanUtils.populate(myBean, map);

        System.out.println("Name: " + myBean.getName());
        System.out.println("Last Name: " + myBean.getLastName());
    }


    public class MyBean {

        public String name;
        public String lastName;
        public String midName;

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getMidName() {
            return midName;
        }

        public void setMidName(String midName) {
            this.midName = midName;
        }
    }



}


