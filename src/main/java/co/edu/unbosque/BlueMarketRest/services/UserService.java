package co.edu.unbosque.BlueMarketRest.services;

import co.edu.unbosque.BlueMarketRest.dtos.User;
import com.opencsv.bean.*;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class UserService {

    public List<User> getUsers() throws IOException {

        List<User> users;

        try (InputStream is = UserService.class.getClassLoader()
                .getResourceAsStream("users.csv")) {

            HeaderColumnNameMappingStrategy<User> strategy = new HeaderColumnNameMappingStrategy<>();
            strategy.setType(User.class);

            try (BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {

                CsvToBean<User> csvToBean = new CsvToBeanBuilder<User>(br)
                        .withType(User.class)
                        .withMappingStrategy(strategy)
                        .withIgnoreLeadingWhiteSpace(true)
                        .build();

                users = csvToBean.parse();
            }
        }

        return users;
    }

    public User createUser(String username, String name, String lastname, String mail, String password, String Fcoins, String path) throws IOException {
        String newLine = username + "," + name + "," + lastname + "," + mail + "," + password + "," + Fcoins + "\n";
        FileOutputStream os = new FileOutputStream(path + "WEB-INF/classes/" + "users.csv", true);
        System.out.println("WEB-INF/classes/");
        os.write(newLine.getBytes());
        os.close();
        return new User(username, name, lastname, mail, password, Fcoins);
    }


}