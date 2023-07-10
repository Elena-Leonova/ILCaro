package manager;

import models.User;
import org.testng.annotations.DataProvider;

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
                .withEmail("lena.postrash@gmail.com")
                .withPassword("Mynameislena1!")});
        list.add(new Object[]{new User()
                .withEmail("lena.postrash@gmail.com")
                .withPassword("Mynameislena1!")});
        return list.iterator();
    }
}
