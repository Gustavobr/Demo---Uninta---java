/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controllers;

import br.com.Models.Participante;
import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

@ManagedBean(name = "p_controller")
@ViewScoped
public class ParticipanteController {
    
    Participante p = new Participante();
    
    public ParticipanteController(){
        
    }
    
    public Participante getP() {
        return p;
    }
    
    public void setP(Participante p) {
        this.p = p;
    }
    
    public void salvar() throws EntityNotFoundException, IOException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Siv_congressoPU");
        EntityManager em = emf.createEntityManager();
       // try {
            /* implementando validacao de objeto - instância */
           // if (p.getNome() != null & p.getEmail() != null & p.getCurso() != null) {
                em.getTransaction().begin();
                em.persist(p);
                em.getTransaction().commit();
                System.out.println(p);
                em.close();
                emf.close();
                
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Participante" + p.getNome() + "\n" + "Cadastrado"));
                //FacesContext.getCurrentInstance().getExternalContext().redirect("index");
            }
            
       // } catch (EntityNotFoundException ex) {
            //throw new EntityNotFoundException("Erro ao persistir objeto na base" + ex.getMessage().toUpperCase());
       // } finally {
         //   em.close();
            //fecha conexao.
        }
        
   // }
    

