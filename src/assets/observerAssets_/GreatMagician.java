package assets.observerAssets_;

import assets.angelsAssets_.Angel;
import assets.playerAssets_.Player;
import fileio.implementations.FileWriter;

import java.util.Observable;
import java.util.Observer;

public class GreatMagician implements Observer {
    private static GreatMagician instance = null;
    private FileWriter fw;

    private GreatMagician() {

    }

    public static GreatMagician getInstance() {
        if (instance == null) {
            instance = new GreatMagician();
        }
        return instance;
    }

    public void setFw(FileWriter fw) {
        this.fw = fw;
    }

    @Override
    public void update(Observable observable, Object o) {
        try {
            if (observable instanceof Player) {
                Player invoker = (Player) observable;
                if (o instanceof Player) {
                    Player affected = (Player) o;
                    if (affected.getHp() <= 0) {
                        fw.writeWord("Player " + affected.getName()
                                + " was killed by " + invoker.getName() + "\n");
                    }
                } else if (o instanceof Angel) {
                    Angel angel = (Angel) o;
                    fw.writeWord(angel.getName() + angel.getAction()
                            + invoker.getName() + "\n");
                } else if (o instanceof Integer) {
                    int oldLevel = (int) o;
                    oldLevel++;
                    int currentLevel = invoker.getLevel();
                    while (oldLevel <= currentLevel) {
                        fw.writeWord(invoker.getName()
                                + " reached level " + oldLevel + "\n");
                        oldLevel++;
                    }
                }
            } else if (observable instanceof Angel) {
                Angel angel = (Angel) observable;
                if (o instanceof Integer) {
                    fw.writeWord("Angel " + angel.getName() + " was spawned at "
                            + angel.getPosition().toString() + "\n");
                } else if (o instanceof Player) {
                    Player affected = (Player) o;
                    if (affected.getHp() <= 0) {
                        fw.writeWord("Player " + affected.getName()
                                + " was killed by an angel\n");
                    } else {
                        fw.writeWord("Player " + affected.getName()
                                + " was brought to life by an angel\n");
                    }
                }
            }
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }
    /*
    public void update(Observable observable, Object o) {
        if (observable instanceof Player) {
            Player invoker = (Player) observable;
            if (o instanceof Player) {
                Player affected = (Player) o;
                if (affected.getHp() <= 0) {
                    System.out.println("Player " + affected.getName() + " was killed by "
                            + invoker.getName());
                }
            } else if (o instanceof Angel) {
                Angel angel = (Angel) o;
                System.out.println(angel.getName() + angel.getAction() + invoker.getName());
            } else if (o instanceof Integer) {
                System.out.println(invoker.getName() + " reached level " + invoker.getLevel());
            }
        } else if (observable instanceof Angel) {
            Angel angel = (Angel) observable;
            if (o instanceof Integer) {
                System.out.println("Angel " + angel.getName() + " was spawned at "
                        + angel.getPosition().toString());
            } else if (o instanceof Player) {
                Player affected = (Player) o;
                if (affected.getHp() <= 0) {
                    System.out.println("Player " + affected.getName() + " was killed by an angel");
                } else {
                    System.out.println("Player " + affected.getName()
                            + " was brought to life by an angel");
                }
            }
        }
    }
     */
}
