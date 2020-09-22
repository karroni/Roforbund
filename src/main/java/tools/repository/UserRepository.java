package tools.repository;

import java.io.Console;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdk.internal.org.jline.utils.Log;
import models.UserModel;
import tools.DbTool;

public class UserRepository {
    /**
     * legger til bruker til databasen.
     * Denne er ikke implementert. Her må dere gjerne prøve å lage en egen servlet som kan kommunisere med
     * denne metoden.
     * @param user bruker objekt som inneholder all informasjon om personen.
     * Tips: Objektet må instansieres i en servlet før man kaller på addUser().
     */

    public static void addUser(UserModel user) {
        Connection db = null;
        PreparedStatement insertNewUser = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn();
            String query =
                "INSERT INTO `user` (User_firstName, User_lastName,User_Email, User_password ) values (?,?,?,?)";

            insertNewUser = db.prepareStatement(query);
            insertNewUser.setString(1, user.getFirstName());
            insertNewUser.setString(2, user.getLastName());
            insertNewUser.setString(3, user.getUserName());
            insertNewUser.setString(4, user.getPassword());
            insertNewUser.execute();
        } catch (SQLException throwables) {
            System.out.println("Feil");
            throwables.printStackTrace();
        } finally {
            try {
                db.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }

    public static ArrayList<ArrayList<String>> getAllMembers(Integer klubbID, PrintWriter p) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        ArrayList<ArrayList<String>> userProfiles = new ArrayList<>();
        try {
            db = DbTool.getINSTANCE().dbLoggIn();
            ResultSet rs = null;
            String query = "SELECT * FROM otra.users where Klubb_id = ?";
            prepareStatement = db.prepareStatement(query);
            prepareStatement.setInt(1, klubbID);
            rs = prepareStatement.executeQuery();
            String alreadyAdded = "";

            while (rs.next()) {
                ArrayList<String> profileInfo = new ArrayList<>();
                int currentAdd = rs.getInt("User_id");

                profileInfo.add(String.valueOf(currentAdd));
                profileInfo.add(rs.getString("User_firstName"));
                profileInfo.add(rs.getString("User_lastName"));
                userProfiles.add(profileInfo);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userProfiles;
    }

    public static String[] getAllCats(Integer userID, PrintWriter p) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        ArrayList<String> toReturn = new ArrayList<>();
        try {
            db = DbTool.getINSTANCE().dbLoggIn();
            ResultSet rs = null;
            String query = "SELECT * FROM otra.resultater where UserID = ?";
            prepareStatement = db.prepareStatement(query);
            prepareStatement.setInt(1, userID);
            rs = prepareStatement.executeQuery();
            String alreadyAdded = "";

            while (rs.next()) {
                int currentAdd = rs.getInt("OvelseID");
                if (!alreadyAdded.contains(String.valueOf(currentAdd))) {
                    alreadyAdded = alreadyAdded + String.valueOf(currentAdd);
                    String ovelsesNavn = getString("otra.ovelser", "Ovelse_ID", currentAdd,"Ovelse_navn");
                    toReturn.add(ovelsesNavn);
                }
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        String[] arrayOfEverything = new String[toReturn.size()];
        arrayOfEverything = toReturn.toArray(arrayOfEverything);

        return arrayOfEverything;
    }

    public static Integer getInt(String database, String searchKey, int searchInt, String whatData) {
        return getInt(database, searchKey, null, String.valueOf(searchInt), whatData);
    }

    public static Integer getInt(String database, String searchKey, String searchString, String whatData) {
        return getInt(database, searchKey, searchString, null, whatData);
    }

    public static Integer getInt(String database, String searchKey, String searchString, String searchInter, String whatData) {
        int searchInt = 0;
        if (searchInter != null) {
            searchInt = Integer.parseInt(searchInter);
        }

        Connection db = null;
        PreparedStatement prepareStatement = null;

        int toReturn = 0;
        try {
            db = DbTool.getINSTANCE().dbLoggIn();
            ResultSet rs = null;
            String query = "SELECT * FROM " + database + " where " + searchKey + " = ?";
            prepareStatement = db.prepareStatement(query);
            if (searchInter == null) {
                prepareStatement.setString(1, searchString);
            }else {
                prepareStatement.setInt(1, searchInt);
            }

            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                toReturn = rs.getInt(whatData);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return toReturn;
    }

    public static String getString(String database, String searchKey, int searchInt, String whatData) {
        return getString(database, searchKey, null, String.valueOf(searchInt), whatData);
    }

    public static String getString(String database, String searchKey, String searchString, String whatData) {
        return getString(database, searchKey, searchString, null, whatData);
    }

    public static String getString(String database, String searchKey, String searchString, String searchInter, String whatData) {
        int searchInt = 0;
        if (searchInter != null) {
            searchInt = Integer.parseInt(searchInter);
        }

        Connection db = null;
        PreparedStatement prepareStatement = null;

        String toReturn = null;
        try {
            db = DbTool.getINSTANCE().dbLoggIn();
            ResultSet rs = null;
            String query = "SELECT * FROM " + database + " where " + searchKey + " = ?";
            prepareStatement = db.prepareStatement(query);
            if (searchInter == null) {
                prepareStatement.setString(1, searchString);
            }else {
                prepareStatement.setInt(1, searchInt);
            }

            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                toReturn = rs.getString(whatData);
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return toReturn;
    }

    //Tenkte å endre denne til 'isUserAuthenticated', hvor programmet sjekker om brukeren er authenticated
    public static String getUserPassword(String username) {
        Connection db = null;
        PreparedStatement prepareStatement = null;

        String toReturn = null;

        try {
            db = DbTool.getINSTANCE().dbLoggIn();
            ResultSet rs = null;
            String query = "SELECT * FROM otra.users where User_email = ?";
            prepareStatement = db.prepareStatement(query);
            prepareStatement.setString(1, username);
            rs = prepareStatement.executeQuery();
            while (rs.next()) {
                toReturn = rs.getString("User_password");
            }
            rs.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return toReturn;
    }
}