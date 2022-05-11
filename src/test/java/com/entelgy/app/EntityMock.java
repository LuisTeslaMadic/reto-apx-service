package com.entelgy.app;

import com.entelgy.app.models.entity.User;
import com.entelgy.app.models.entity.UserModalData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EntityMock {

    public static UserModalData mockUserModal(){
        UserModalData input = new UserModalData();
        input.setData(new ArrayList<>());
        input.getData().add(new User());
        input.getData().get(0).setId(1);
        input.getData().get(0).setAvatar("Fuero");
        input.getData().get(0).setEmail("Fuero@gmail.com");
        input.getData().get(0).setFirst_name("Juan");
        input.getData().get(0).setLast_name("Juarez");
        return input;
    }
    public static List<String> mockMapList(){
        return Arrays.asList("<1>|<Juarez>|<Fuero@gmail.com>","<2>|<Weaver>|<janet.weaver@reqres.in>");
    }
}
