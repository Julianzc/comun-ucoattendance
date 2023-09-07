package co.edu.uco.comun.validator;

import co.edu.uco.comun.exceptions.InvalidValueException;
import co.edu.uco.comun.exceptions.LenghtValueException;
import co.edu.uco.comun.exceptions.RequiredValueException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArgumentValidator {

    private ArgumentValidator() {}

    public static void validateRequired(Object value, String message) {
        if (value == null || "".equals(value)) {
            throw new RequiredValueException(message);
        }
    }

    public static void validateNotEmpty(String value, String message) {
        if (value.isEmpty()) {
            throw new RequiredValueException(message);
        }
    }

    public static void validateLenght(String value,int lenght,String message){
        if(value.length() < lenght){
            throw new LenghtValueException(message);
        }
    }

    public static <T> void validateNotEmpty(List<T> list, String message) {
        if (list.isEmpty()) {
            throw new RequiredValueException(message);
        }
    }

    public static void validatePositive(Double value, String message) {
        if (value <= 0) {
            throw new InvalidValueException(message);
        }
    }

    public static void validateMoreThanZero(Integer value, String message){
        if(value < 1){
            throw new InvalidValueException(message);
        }
    }

    public static void validateEqual(Double value, Double expectedValue, String message) {
        if (!value.equals(expectedValue)) {
            throw new InvalidValueException(message);
        }
    }

    public static void validateMinimumLenght(Object value, int minimumLenght, String message) {
        if (value.toString().length() < minimumLenght) {
            throw new InvalidValueException(message);
        }
    }

    public static void validateMinor(Long initialNumber, Long finalNumber, String message) {
        if (initialNumber > finalNumber) {
            throw new InvalidValueException(message);
        }
    }

    public static void validateRegex(String correoElectronico, String regex, String message) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correoElectronico);

        if (!matcher.matches()) {
            throw new InvalidValueException(message);
        }
    }

    public static <E extends Enum<E>> E validateValid(String value, Class<E> enumAObtener, String message) {
        E enumObtenido = null;
        if(null != value) {
            Optional<E> resultadoOpcional = Arrays.stream(enumAObtener.getEnumConstants())
                    .filter(resultado -> resultado.toString().equals(value)).findFirst();

            if (resultadoOpcional.isPresent()) {
                enumObtenido = resultadoOpcional.get();
            } else {
                throw new InvalidValueException(message);
            }
        }
        return enumObtenido;
    }

    public static void validateNumeric(String value,String message) {
        try {
            Long.parseLong(value);
        } catch (NumberFormatException numberFormatException) {
            throw new InvalidValueException(message);
        }
    }
}
