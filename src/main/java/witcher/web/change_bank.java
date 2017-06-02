/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.web;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;
import witcher.ejbs.BankBean;
import witcher.entities.bank;
import witcher.entities.guest;
import witcher.util.SessionUtils;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@RequestScoped
public class change_bank implements Serializable {
    @EJB
    private BankBean bankBean;
    
    private Integer bankId;

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }
    
    public List<SelectItem> getAllBanks() {

        List<SelectItem> items = new ArrayList<SelectItem>();
        List<bank> bankList = bankBean.getBanks();
        for (bank bank : bankList) {
            items.add(new SelectItem(bank.getId(), bank.getName()+" commission: "+bank.getCommision()*100.0+"%"));
        }
        return items;
    }
    
    public String changeBank() {
        guest User = SessionUtils.getUser();
        bankBean.changeBank(User, bankId);
        return "index";
    }
    
}
