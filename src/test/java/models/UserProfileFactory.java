package models;
import com.github.javafaker.Faker;

public class UserProfileFactory {
    static Faker faker = new Faker();

    public static UserProfile getFillingUserProfileForm() {
        return UserProfile.builder()
                .firstName(faker.gameOfThrones().character())
                .lastName(faker.gameOfThrones().character())
                .gender("Female")
                .birthday("21/10/2000")
                .weight("60")
                .country("Belarus")
                .state("Vitsyebskaya voblasts")
                .city(faker.gameOfThrones().city())
                .zip("222301")
                .build();

    }

}
