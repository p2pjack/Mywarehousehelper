package com.uk.umf_solutions.warehousehelper.Data;

/**
 * Created by Eaun-Ballinger on 03/03/2017.
 *
 */

public class DatabaseHelper {

//
//    public DatabaseHelper(Context context) {
//    }
//
//    public boolean createUser(User user) {
//        try {
//            realm.beginTransaction();
//            realm.copyToRealm(user);
//            realm.commitTransaction();
//            realm.close();
//            return true;
//        } catch (RealmException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public boolean deleteUser(String email) {
//        try {
//            RealmResults<User> user = realm.where(User.class).equalTo(DbConstants.EMAIL_KEY, email)
//                    .findAll();
//            user.clear();
//            return true;
//        } catch (RealmException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
//
//    public User readUser(String email) {
//        User user = realm.where(User.class).equalTo(DbConstants.EMAIL_KEY, email)
//                .findFirst();
//        return user;
//    }
//
//    public boolean isUserExist(String email) {
//        try {
//            RealmResults<User> user = realm.where(User.class).equalTo(DbConstants.EMAIL_KEY, email)
//                    .findAll();
//            if (user.size() > 0) {
//                return true;
//            } else {
//                return false;
//            }
//        } catch (RealmException e) {
//            e.printStackTrace();
//            return false;
//        }
//    }
}
