package fr.vozoul.game.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlDatabase {

    public void tryToConnect(){
        try{
            Connection cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/Monopoly?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "admin", "root");
            System.out.println("connection reussi");
        }catch(Exception e){
            e.getMessage();
        }
    }
}
