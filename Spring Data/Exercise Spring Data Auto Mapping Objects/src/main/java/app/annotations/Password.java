package app.annotations;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;

@Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
@Documented
public @interface Password {
    String message() default  "Invalid Password!!!";

    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };

    int minLength() default 6;
    int maxLength() default 30;
    boolean containsDigit() default false;
    boolean containsLowerCase() default false;
    boolean containsUpperCase() default false;

    @Target({METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER, TYPE_USE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List{
        Password[] value();
    }
}
