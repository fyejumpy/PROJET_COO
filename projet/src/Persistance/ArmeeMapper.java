/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistance;

import Domaine.Armee;
import Domaine.Joueur;
import Domaine.Personne;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Classe permettant l'envoi et la réception des différents attributs de l'objet Armee
 * @author lemoine
 */
public class ArmeeMapper {

        // constantes
        //static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
        static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
        static final String DB_URL = "jdbc:oracle:thin:@oracle.fil.univ-lille1.fr:1521:filora";
        String userName = "LEMOINE_ED";
        String password = "saturnin";

        
        private IdentityMap<Armee> idmapA;
        private Connection conn;
        
        // gestion singleton
        static ArmeeMapper inst = null;
        public static ArmeeMapper getInstance() {
                if (inst == null) {
                        inst = new ArmeeMapper();
                }
                return inst;
        }


        //Constructeur de la classe
        public ArmeeMapper() {
                try {
                        Class.forName(JDBC_DRIVER);
                        conn = DriverManager.getConnection(DB_URL, userName, password);
                        idmapA = new IdentityMap<Armee>();
                } catch (Exception e) {
                        System.out.println("Une erreur s'est produite");
                        e.printStackTrace();
                        System.exit(1);
                }
        }

        //Méthode permettant l'insertion dans la base
        public void insert(Armee a) {
                String req = "INSERT INTO PERSONNE(IDPERS,NOM,PRENOM, EVAL) VALUES(?, ?, ?, ?)";
                try {
                        PreparedStatement ps = conn.prepareStatement(req);
                        ps.setString(1, a.getIdArmee());
                        /*ps.setString(2, j.getNom());
                        ps.setString(3, j.getPrenom());*/
                        ps.executeUpdate();
                        idmapA.put(a.getIdArmee(), a);
                        a.add(UoW.getInstance());
                } catch (Exception e) {
                        System.out.println("Une erreur s'est produite lors de l'insert.");
                        e.printStackTrace();
                        System.exit(1);
                }
        }

        //Permet de trouver l'ensemble des fils d'une personne suivant son id
        public List<Armee> findArmeeById(String id) {
                List<Armee> listArmee = new ArrayList<Armee>();
                System.out.println("On exec la méthode find fils");
                String req = "SELECT idPers, NOM, PRENOM, EVAL FROM PERSONNE WHERE idPERE = ?";
                try {
                        PreparedStatement ps = conn.prepareStatement(req);
                        ps.setString(1, id);
                        ResultSet rs = ps.executeQuery();
                        System.out.println("TEST");

                        //Affectation des personnes
                        while(rs.next()){
                            System.out.println(rs.getString("idpers"));
                            /*Joueur p1= new Joueur();
                            p1.setId(rs.getString(1));
                            p1.setNom(rs.getString(2));
                            p1.setPrenom(rs.getString(3));
                            p1.setEval(rs.getString(4));
                            System.out.println(p1);
                            p1.add(UoW.getInstance());
                            listFils.add(p1);   */

                            /*Recuperation tableau armee*/
                        }
                }catch(Exception e){
                    System.out.println("Erreur lors de la méthode find fils.");
                }
                // on renvoie la liste des personnes qui ont amies avec la personne ayant pour id: l'id demandé
                return listArmee;
        }

        //Methode permettant de trouver une armee suivant son id
        public Armee find(String Id) {
                Armee a = idmapA.get(Id);
                if (a != null)
                        return a;

                String req = "SELECT nom, prenom, eval, idpere FROM PERSONNE WHERE IdPers=?";
                try {
                        PreparedStatement ps = conn.prepareStatement(req);
                        ps.setString(1, Id);
                        ResultSet rs = ps.executeQuery();

                        rs.next(); // exception si y'a pas de résultat
                        /*j = new Joueur();
                        j.setId(Id);
                        p.setNom(rs.getString(1));
                        p.setPrenom(rs.getString(2));
                        p.setEval(rs.getString(3));
                        p.ajoutPere(findPere(rs.getString(4)));*/
                        
                        System.out.println(a.getIdArmee());
                        idmapA.put(a.getIdArmee(), a);
                        a.add(UoW.getInstance());
                        return a;

                } catch (Exception e) {
                        System.out.println("Une erreur s'est produite");
                        e.printStackTrace();
                        return null;
                }
        }


        //Methode permettant la mise à jour d'un objet personne dans la base
        //Ici on ne gère que l'évaluation
        public void update(Armee a) {

                String req = "UPDATE Personne SET Eval=? where idPers=?";
                try {
                        PreparedStatement ps = conn.prepareStatement(req);
                        ps.setString(1, a.getJoueur().getPseudo());
                        ps.setString(2,a.getIdArmee());
                        /*mettre coordonnee*/
                        /*ensemble infos de maj'*/
                        ps.executeUpdate();

                } catch (Exception e) {
                        System.out.println("Une erreur s'est produite");
                        e.printStackTrace();
                }
        }
}
