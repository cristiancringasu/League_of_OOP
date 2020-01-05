323CD CRINGASU CRISTIAN

Cum am facut tema?

Am folosit cateva clase:
¤ Player - clasa generica care contine toate particularitatile comune ale tuturor playerilor
*    extinsa de ROGUE, WIZARD, PYROMANCER si KNIGHT 
                    ; aduc in plus date de HP, max HP si HP / level + 
                    amanunte legate de abilitati :
                                   * backstab counter la ROGUE, contorizeaza numarul de hituri backstab date
                                   * receivedDamage la WIZARD, vede cat damage a primit recent de la ultimul player implicat in lupta cu el
                    
¤ Ability _ interfata - operatiile care se fac pe playeri, operatii fara efect prelungit
                extinsa de fiecare abilitate a fiecarui jucator, care isi implementeaza propria lor logica de joc
¤ PerpetualAbility _ interfata - efectele prelungite ale unor diverse abilitati

Am ales tipul lor de interfata pentru mostenirea multipla a unor abilitati de tipul basic + perpetual (ex: Ignite).

¤ Modifier - modificatori de rasa, terene, pentru fiecare player si abilitate

¤ GameMap - harta de tipul          LandType [int][int] -> LAND, SINGLETON din motive evidente :)

¤ GameInput si GameInputLoader, refolosite de la tema anterioara, adaptate pentru citirea noilor tipuri de date, 
        pastreaza logica insa :)

¤ PlayerFactory - ii dau un caracter si imi returneaza un player de tipul "cerut" -> WOW, ce destept !

¤ Round - joaca o runda: se fac miscarile tuturor playerilor neparalizati, se efectuaza damage urile date de abilitati perpetual, 
    se bat jucatorii unul cu altul parcurgand fiecare combinatie de doi playeri, comparand pozitiile lor si hp-ul (> 0, la amandoi =>
    inmultit > 0)

¤ Score - printeaza scorul in fisier si pe consola, depinde de preferinte

¤Debugger - a fost cineva destul de smecher pe grupul seriei si a postat out urile frumos facute pentru fiecare runda, eu mi am
    reprodus modalitatea de printare a lui si dadeam doar diff pentru evidentierea diferentelor, implicit a erorilor :)

¤ IntegerTulep - pentru pozitie!

Ok, asta a fost tot.. sau NU! 

DoubleDispatch, unde l-am folosit?

Stim de la laboratoare de Design Patternul Visitor, care separa operatiile de operanzi, avem deci clasa AbilityApplier, care are rolul 
de a face double dispatch ul : Player are metoda fight, echivalenta cu o metoda de tipul acceptVisitor, iar AbilityApplier 
are metoda applyAbility, care are rolul unei metode de tipul visit(Player). Deci mai intai ne ducem pe player ul respectiv, acesta face
applyAbility de *this* (polimorfism dinamic), intra pe ramura lui din AbilityApplier, in fuctie de tipul sau de player, si isi primeste
abilitatile, pe care le efectueaza.

Acum, da , am terminat!
    

EDIT: UPDATE ETAPA 2_________________

Am adaugat:

* Angel: Entitate noua care adauga niste bonusuri sau nu chiar la jucatori : XP, modificatori, HP,  etc
        La aceasta entitate se adauga o clasa cu rol de visitor: DispatchPlayerSelector, care va selecta o actiune 
        in functie de inger si player, deci apare o noua metoda in Player: acceptAngel (abstracta, implementate de 
        fiecare player in parte).
        
        Este subclasata de fiecare tip de inger, si implementeaza o actiune pentru fiecare tip de jucator.
        
* AngelFactory: fabrica de ingeri, stie sa adauge si un observar la fiecare nou inger creeat, adica pe Marele HocusPocus

* PlayerStrategy: interfata, foloseste desgn pattern ul Strategy pentru a selectea dinamic strategia la runtime.
                  Este implementata de fiecare strategie corespunzatoare fiecarui jucator in parte, identificandu-se
                  pentru un jucator 2 tipuri de strategii: Offensive si Deffensive.
                  
                  Astfel apare in clasa Player metoda selectStrategy(), abstracta, implementate unic de fiecare jucator.
                  
* GreatMagician, observator la tot ce se intampla in joc, afiseaza in fisier toate evenimentele importante(bataie, 
                        sange, inger, etc)
                        
Am schimbat clasele GameInput, GameInputLoader si Round pentru a linka noile feature uri in joc (citire, aplicare, 
                    stocare, etc)
                    
Am schimbat unele abilitati si logici de rezolvare (aproximari, etc, in functie de rezultatul pe teste).

Tema muncitoreasca.. NU APRECIEZ ASA CEVA!!!


