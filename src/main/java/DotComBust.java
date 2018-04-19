import java.util.ArrayList;

/**
 * Created by sbt-eltyshev-vs on 17.04.2018.
 */
public class DotComBust {

    private GameHalper helper = new GameHalper();
    protected ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
    private int numOfGuesses = 0;

    private void setUpGame(){
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");
        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);
        System.out.println("Ваша цель - потопить 3 сайта");
        System.out.println("Попытайтесь потопить их за минимальное к-во ходов");
        for (DotCom dotComToSet : dotComsList){
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }

    private void startPlaying(){
        while(!dotComsList.isEmpty()){
            String userGuess = helper.getUserInput("Сделайте ход");
            checkUserGuess(userGuess);
        }
        finishGame();
    }

    private void checkUserGuess(String userGuess){
        numOfGuesses++;
        String result = "Мимо";
        for (DotCom dotComToSet : dotComsList){
            result = dotComToSet.checkYourself(userGuess);
            if (result.equals("Попал")){
                break;
            }
            if (result.equals("Потопил")){
                dotComsList.remove(dotComToSet);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame(){
        System.out.println("Все сайты ушли к дну");
        if (numOfGuesses <= 18){
            System.out.println("Это заняло у вас всего "+ numOfGuesses + " попыток");
            System.out.println("Вы успели выбраться до того как ваши вложения утонули");
        } else {
            System.out.println("Это заняло у вас довольно много времени. " + numOfGuesses + " попыток");
            System.out.println("рыбы водят хороводы вокруг ваших вложений.");
        }
    }

    public static void main(String[] args){
        System.out.println("рыбы водят хороводы вокруг ваших вложений.");
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }
}
