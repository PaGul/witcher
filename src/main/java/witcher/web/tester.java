/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package witcher.web;

import java.util.HashMap;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import witcher.tests.*;

/**
 *
 * @author pavelgulaev
 */
@ManagedBean
@RequestScoped
public class tester {
    
    boolean fullResult = false;
    boolean clicked = false;

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }
    
    public boolean isResult() {
        return fullResult;
    }

    public void setResult(boolean result) {
        this.fullResult = result;
    }
    
    @EJB
    private get_money_test testRunnerGM;
    
    public void runTests() {
        HashMap<Object, Boolean> get_money_test_coverage = new HashMap<>();
        get_money_test_coverage.put(10, Boolean.TRUE);
//        get_money_test_coverage.put(-1, Boolean.FALSE);
//        get_money_test_coverage.put(1000, Boolean.TRUE);
//        get_money_test_coverage.put("Test", Boolean.FALSE);
        boolean result = true;
        for (Object test : get_money_test_coverage.keySet()) {
            result = result & (get_money_test_coverage.get(test)==testRunnerGM.addMoney_test(test));
        }
        
//        new_ad_test testRunnerNA = new new_ad_test();
//        HashMap<TestAd, Boolean> new_ad_test_coverage = new HashMap<>();
//        new_ad_test_coverage.put(new TestAd("Убить кикимору", "Живет в лесу, ест людей", 100), Boolean.TRUE);
//        new_ad_test_coverage.put(new TestAd("Уничтожить кикимору,которая сидит на опушке леса. Раньше она была доброй и никого не трогала, а сейчас совсем разбушевалась.", "Находится на Трихоуховых полях. Появляется в после полуночи. Пугает людей", 300), Boolean.FALSE);
//        new_ad_test_coverage.put(new TestAd("Уничтожить кикимору", "Сегодня существует несколько вариантов lorem цель применения. Цель применения такого текста сыграет. Вставки на том языке, который планируется использовать в различных. Книгопечатник вырвал отдельные фразы и слова, получив текст-рыбу широко. Вставки на латыни и по сей день. Ему нести совсем необязательно широко. Такое текст-рыба знаменитый lorem написание символов на кириллице значительно. Сайтах и даже с разной. Сайтах и зла средневековый книгопечатник вырвал отдельные фразы и проектах ориентированных. Распространенных слов никакого отношения к обитателям водоемов считается. Использующими латинский алфавит, могут возникнуть небольшие проблемы: в качестве рыбы текст. Кириллице значительно различается пределах добра и зла средневековый. Абзацев, отступов и смысловую нагрузку. Обитателям водоемов философу цицерону, ведь именно. Наиболее распространенных слов каждый веб-разработчик знает, что такое ", 300), Boolean.FALSE);
//        new_ad_test_coverage.put(new TestAd("Убить кикимору", "Живет в лесу, ест людей", 1001), Boolean.FALSE);
//        new_ad_test_coverage.put(new TestAd("Убить кикимору", "Живет в лесу, ест людей", -1), Boolean.FALSE);
//        
//        for (TestAd testAd : new_ad_test_coverage.keySet()) {
//            result = result & (testRunnerNA.newAd_test(testAd.header, testAd.text, testAd.price)==new_ad_test_coverage.get(testAd));
//        }
        fullResult = result;
        clicked = true;
    }
    
    class TestAd {
        public String header;
        public String text;
        public Integer price;

        public TestAd(String header, String text, Integer price) {
            this.header = header;
            this.text = text;
            this.price = price;
        }
        
    }
}
