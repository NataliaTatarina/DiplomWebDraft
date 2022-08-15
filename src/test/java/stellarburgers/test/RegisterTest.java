package stellarburgers.test;

public class RegisterTest {


    //// Перейти к регистрации по клику на "Войти в аккаунт"
    //// Убедиться, что открылась форма входа - есть надпись "Вход"
    //// Нажать ссылку - "Зарегистрироваться"
    //// Убедиться, что открылась форма регистрации - есть надпись "Регистрация"
    //// Заполнить корректно поля "Имя", "Email", "Пароль"
    //// Нажать кнопку "Зарегистрироваться"
    //// Убедиться, что регистрация прошла успешно - форма регистрации сменилась на форму входа
    //// Есть надпись "Вход"
    //// Удалить учетную запись пользователя
/*
// Удалить пользователя
        deleteUserCheckStatus(requestSpec, userRegister, token);
public static void deleteUserCheckStatus(RequestSpecification requestSpec, UserRegister userRegister, String token) {
        given()
                .spec(requestSpec)
                .and()
                .body(userRegister)
                .auth().oauth2(token)
                .when()
                .delete("auth/user")
                .then()
                .statusCode(SC_ACCEPTED);
    }
 */
}
