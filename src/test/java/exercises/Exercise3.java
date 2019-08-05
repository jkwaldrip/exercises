package exercises;

import api.RandomUserApi;
import api.data.PrimaryAddress;
import api.data.User;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class Exercise3 {

    @Test
    public void getRandomUser() throws IOException {
        // Get random user from API
        User randomUser = RandomUserApi.getRandomUser();

        // Validate user fields
        assertThat(randomUser.getFirstName())
                .isNotBlank();
        assertThat(randomUser.getLastName())
                .isNotBlank();
        assertThat(randomUser.getEmail())
                .isNotBlank();
        assertThat(randomUser.getGender())
                .isNotBlank();
        assertThat(randomUser.getBirthDate())
                .isNotBlank();

        // Validate address fields
        PrimaryAddress address = randomUser.getPrimaryAddress();
        assertThat(address.getStreet())
                .isNotBlank();
        assertThat(address.getCity())
                .isNotBlank();
        assertThat(address.getState())
                .isNotBlank();
        assertThat(address.getZipCode())
                .isNotBlank();
        assertThat(address.getTimeZone())
                .isNotBlank();
    }
}
