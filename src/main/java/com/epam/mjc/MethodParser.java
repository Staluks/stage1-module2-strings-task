package com.epam.mjc;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) {


        Collection<String> delimiters = new ArrayList<>();
        delimiters.add(" ");
        delimiters.add("(");
        delimiters.add(")");
        delimiters.add(",");

        List<String> modifier = new ArrayList<>();
        modifier.add("public");
        modifier.add("protected");
        modifier.add("default");
        modifier.add("private");

        List<String> stringSplitter = new ArrayList<>();
        stringSplitter.add(signatureString);
        List<MethodSignature.Argument> arguments = new ArrayList<>();

//        MethodSignature.Argument kaka = new MethodSignature.Argument();

        StringSplitter spliter = new StringSplitter();
        List<String>splittedString = spliter.splitByDelimiters(signatureString, delimiters);
        if(!modifier.contains(splittedString.get(0))){
            splittedString.add(0, null);
        }
        if(splittedString.size()>3){
            for(int i = 3; i< splittedString.size(); i = i+2 ){
                arguments.add(new MethodSignature.Argument(splittedString.get(i), splittedString.get(i+1)));
            }
        }

        MethodSignature members = new MethodSignature(signatureString, arguments);

        members.setAccessModifier(splittedString.get(0));
        members.setReturnType(splittedString.get(1));
        members.setMethodName(splittedString.get(2));

        return members;
    }
}
