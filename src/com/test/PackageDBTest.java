package com.test;

import com.company.db.PackageDB;
import com.company.db.StackDB;
import com.company.db.UserDB;
import com.company.model.Packages;
import com.company.model.Stack;
import com.company.model.User;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PackageDBTest {

    private PackageDB packageDB = new PackageDB();
    private UserDB userDB = new UserDB();
    private StackDB stackDB = new StackDB();


    private User initUser(){
        return User.builder()
                .userToken("Test-User")
                .username("Username")
                .password("password")
                .coins(10)
                .build();
    }

    private Packages initPackage(){

        ArrayList<String> cardIdList = new ArrayList<>();
        cardIdList.add("card1");
        cardIdList.add("card2");
        cardIdList.add("card3");
        cardIdList.add("card4");
        cardIdList.add("card5");

        return Packages.builder()
                .id("TestPackageID")
                .cardIdPackage(cardIdList)
                .build();
    }

    @Test
    void getItemByToken() {
        Packages packages = initPackage();
        assertNotNull(packages);
        assertTrue(packageDB.deleteItemById(packages.getId()));
        packages = packageDB.addItem(packages);
        assertNotNull(packages);
        packages = packageDB.getItemByToken(packages.getId());
        assertNotNull(packages);
        assertTrue(packageDB.deleteItemById(packages.getId()));
    }

    @Test
    void addItem() {
        Packages packages = initPackage();
        assertNotNull(packages);
        assertTrue(packageDB.deleteItemById(packages.getId()));
        packages = packageDB.addItem(packages);
        assertNotNull(packages);
        assertTrue(packageDB.deleteItemById(packages.getId()));
    }

    @Test
    void sellPackage() {
        //USER
        User user = initUser();
        assertNotNull(user);
        assertTrue(userDB.delete(user.getUserToken()));
        user = userDB.addItem(user);
        assertNotNull(user);
        user = userDB.getItemByToken(user.getUserToken());
        assertNotNull(user);

        //PACKAGE
        Packages packages = initPackage();
        assertNotNull(packages);
        assertTrue(packageDB.deleteItemById(packages.getId()));
        packages = packageDB.addItem(packages);
        assertNotNull(packages);
        packages = packageDB.getItemByToken(packages.getId());
        assertNotNull(packages);

        packageDB.sellPackage(user.getUserToken(), packages.getId());


        for (int i = 1; i < 6; i++){
            stackDB.deleteCardFromStack(user.getUserToken(),"card"+i);
        }

        assertTrue(userDB.delete(user.getUserToken()));
        assertTrue(packageDB.deleteItemById(packages.getId()));

    }

    @Test
    void deleteItemById() {
        assertTrue(packageDB.deleteItemById("asdasd"));
        Packages packages = initPackage();
        assertNotNull(packages);
        assertTrue(packageDB.deleteItemById(packages.getId()));
        packages = packageDB.addItem(packages);
        assertNotNull(packages);
        assertTrue(packageDB.deleteItemById(packages.getId()));
    }
}