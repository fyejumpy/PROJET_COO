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
import java.util.List;
import Persistance.VirtualProxyGenerique.VirtualProxyBuilder;

/**
 * Classe permettant l'envoi et la réception des différents attributs de l'objet Personne
 * @author lemoine
 */
public class JoueurMapper {
                // constantes
		//static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
                static final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
		static final String DB_URL = "jdbc:oracle:thin:@oracle.fil.univ-lille1.fr:1521:filora";
                String userName = "LEMOINE_ED";
                String password = "saturnin";

		// gestion singleton
		static JoueurMapper inst = null;
		public static JoueurMapper getInstance() {
			if (inst == null) {
				inst = new JoueurMapper();
			}
			return inst;
		}

		private IdentityMap<Joueur> idmap;
		private Connection conn;

                //Constructeur de la classe
		public JoueurMapper() {
			try {
				Class.forName(JDBC_DRIVER);
				conn = DriverManager.getConnection(DB_URL, userName, password);
				idmap = new IdentityMap<Joueur>();
			} catch (Exception e) {
				System.out.println("Une erreur s'est produite");
				e.printStackTrace();
				System.exit(1);
			}
		}

                //Méthode permettant l'insertion dans la base
		public boolean insert(Joueur j) {
                    boolean insertOk= false;
			String req = "INSERT INTO JOUEUR(IdPseudo, MDP) VALUES(?, ?)";
			try {
				PreparedStatement ps = conn.prepareStatement(req);
				ps.setString(1, j.getPseudo());
                                ps.setString(2, j.getMdp());
				ps.executeUpdate();
				idmap.put(j.getPseudo(), j);
				j.add(UoW.getInstance());
                                insertOk = true;
			} catch (Exception e) {
				System.out.println("Errreur joueur déjà présent ou même pseudo.");
				e.printStackTrace();
			}
                        return insertOk;
		}


                //Methode permettant de trouver un joueur suivant son id
		public Joueur find(String Id) {
			Joueur j = idmap.get(Id);
			if (j != null)
				return j;

			String req = "SELECT idPseudo FROM JOUEUR WHERE IdPseudo=?";
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
                                  
				Factory<List<Armee> > maFactory = new ListeArmeeFactory(Id);
				j.setListeArmeeJoueur(new VirtualProxyBuilder<List<Armee> >(List.class, maFactory).getProxy());
                                System.out.println(j.getListeArmeeJoueur().get(0).getIdArmee());
                                /*Pareil pour récup de partie*/
                                /*TO DO*/
                                /*Pareil pour ville*/
                                
                                
                                
				idmap.put(j.getPseudo(), j);
				j.add(UoW.getInstance());
				return j;

			} catch (Exception e) {
				System.out.println("Une erreur s'est produite");
				e.printStackTrace();
				return null;
			}
		}
                
                public Joueur find(String IdPseudo, String mdp) {
			Joueur j = idmap.get(IdPseudo);
			if (j != null)
				return j;

			String req = "SELECT idPseudo, mdp FROM JOUEUR WHERE IdPseudo=? AND mdp=?";
			try {
				PreparedStatement ps = conn.prepareStatement(req);
				ps.setString(1, IdPseudo);
                                ps.setString(2, mdp);
				ResultSet rs = ps.executeQuery();

				rs.next(); // exception si y'a pas de résultat
				j = new Joueur(IdPseudo,mdp, 0);
				/*p.setNom(rs.getString(1));
				p.setPrenom(rs.getString(2));
                                p.setEval(rs.getString(3));
                                p.ajoutPere(findPere(rs.getString(4)));*/
                                  
				/*Factory<List<Armee> > maFactory = new ListeArmeeFactory(Id);
				j.setListeArmeeJoueur(new VirtualProxyBuilder<List<Armee> >(List.class, maFactory).getProxy());
                                System.out.println(j.getListeArmeeJoueur().get(0).getIdArmee());*/
                                /*Pareil pour récup de partie*/
                                /*TO DO*/
                                /*Pareil pour ville*/
                                 
				idmap.put(j.getPseudo(), j);
				j.add(UoW.getInstance());
				return j;

			} catch (Exception e) {
				System.out.println("Une erreur s'est produite");
				e.printStackTrace();
				return null;
			}
		}
                
                //Methode permettant de trouver le père d'une personne 
                public Personne findPere(String Id) {
                        Personne p= new Personne();
			String req = "SELECT nom, prenom, eval, idpere FROM PERSONNE WHERE IdPers=?";
			try {
				PreparedStatement ps = conn.prepareStatement(req);
				ps.setString(1, Id);
				ResultSet rs = ps.executeQuery();

				rs.next(); // exception si y'a pas de résultat
				p.setId(Id);
				p.setNom(rs.getString(1));
				p.setPrenom(rs.getString(2));
                                p.setEval(rs.getString(3));
                                
				return p;

			} catch (Exception e) {
				System.out.println("Une erreur s'est produite");
				e.printStackTrace();
				return null;
			}
		}
                   
                //Methode permettant la mise à jour d'un objet Joueur dans la base
                //Ici on ne gère que l'évaluation
		public void update(Joueur j) {

			String req = "UPDATE Personne SET Eval=? where idPers=?";
			try {
				PreparedStatement ps = conn.prepareStatement(req);
				/*ps.setString(1, j.getEval());
                                ps.setString(2,j.getId());*/
				ps.executeUpdate();

			} catch (Exception e) {
				System.out.println("Une erreur s'est produite");
				e.printStackTrace();
			}
		}
	}