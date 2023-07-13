package manager;

import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]>userModelListDTO(){
        // Data Transfer Object
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{new User()
                .withEmail("lena.postrash@gmail.com")
                .withPassword("Mynameislena1!")});
        list.add(new Object[]{new User()
                .withEmail("cat@gmail.com")
                .withPassword("Mynameislena1!")});
        list.add(new Object[]{new User()
                .withEmail("dog@gmail.com")
                .withPassword("Mynameislena1!")});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]>userModelListReg(){
        int i =(int)(System.currentTimeMillis()/1000)%3600;
        List<Object[]>list = new ArrayList<>();
        list.add(new Object[]{new User()
                .withName("sasha")
                .withLastName("petrov")
                .withEmail("petrov" + i + "@gmail.com")
                .withPassword("Mynameislena1!")});
        list.add(new Object[]{new User()
                .withName("vasya")
                .withLastName("smirnov")
                .withEmail("smirnov" + i + "@gmail.com")
                .withPassword("Mynameislena1!")});
        list.add(new Object[]{new User()
                .withName("katya")
                .withLastName("juk")
                .withEmail("juk" + i + "@gmail.com")
                .withPassword("Mynameislena1!")});
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> userModelListDTO_CSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/reg_data.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{new User()
                    .withName(split[0])
                    .withLastName(split[1])
                    .withEmail(split[2])
                    .withPassword(split[3])
            });
            line = reader.readLine();
        }
      return list.iterator();
    }
    }

