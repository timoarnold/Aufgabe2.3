Aufgabe 2 – Implementierung 2 (10 Punkte)

Nachdem Sie die Bestellverwaltung programmiert haben, erweitern wir nun das Aeki Programm mit folgender Funktionalität: Zu jeder Bestellung muss nun eine Auftragsbestätigung erfolgen. Vor der Rücksendung einer Auftragsbestätigung prüft die Fabrik mit dem Lager, ob ausreichende Lagerbestände für die Fertigung der Bestellung vorhanden sind. Wir gehen in unserem Programm von einem Make-To-Order Vorgang aus. Bei geringen Lagerbeständen veranschlagt die Auftragsbestätigung zwei Tage zusätzlich zur Standardlieferzeit, welche Sie mit einem Tag festlegen können. Die Lieferzeit errechnet sich durch die Produktionszeit der bestellten Stühle/Sofas plus die Beschaffungszeit der notwendigen Materialien plus die Standardlieferzeit. Wenn die Bestände niedrig sind, sollte das Lager eine Bestellung beim Lieferanten aufgeben können.

Das erstellte Programm wird somit um zwei weitere Klassen erweitert. Implementieren Sie die Klassen Lager und die Klasse Lieferant. Auch für diese Aufgabe stellen wir Ihnen das dazugehörige Klassendiagramm zur Verfügung.

    Die Klasse Lager beinhaltet die Information zu den maximal lagerbaren Materialeinheiten. Diese sind in den Klassenvariablen maxHolzeinheiten, maxSchrauben, maxFarbeinheiten, maxKartoneinheiten und maxKissen

Implementieren Sie in der Klasse Lager folgende Methoden:

    gibBeschaffungszeit

Die Methode erhält als Parameter eine Kundenbestellung und liefert 0 Tage zurück, wenn alle Materialien für die Produktion aller bestellter Produkte vorhanden sind, und 2 Tage, wenn das Material beim Lieferanten nachbestellt werden muss. Dafür muss die Liste mit allen Produkten der Bestellung durchsucht und die Anzahl benötigter Materialien ausgerechnet werden. Für die Berechnung müssen Sie wissen, ob es sich um einen Stuhl oder um ein Sofa handelt. Mit folgender Abfrage könne Sie dies erfahren:

    if(produkt instanceof Stuhl){

       ….

    }else if(produkt instanceof Sofa){

       ….

    }

Die Variable product ist vom Typ Produkt.

    - lagerAuffuellen

Diese Methode bestellt fehlende Produkte beim Lieferanten nach und füllt nach Erhalt das Lager wieder auf.

    - lagerBestandAusgeben

Diese Methode druckt die im Lager vorhandenen Materialeinheiten auf die Konsole aus.

    Die Klasse Lieferant besitzt nur eine Methode, welche der Fabrik ermöglicht, eine Bestellung aufzugeben.

Die Klassen Lager und Lieferant müssen auch noch erzeugt werden. Überlegen Sie sich genau, wo diese Klassen instanziiert werden müssen. Auch sind Anpassungen in den Klassen Bestellung und Fabrik notwendig.

In der Klasse Bestellung muss zu jeder Instanz auch die korrekter Beschaffungszeit und die entsprechende Lieferzeit gesetzt werden können. Eine Methode, welche die Liste mit allen bestellten Produkten einer Bestellung retourniert, wird auch in der Klasse Bestellung benötigt.

In der Klasse Fabrik ändert sich die Methode bestellungAufgeben, indem die Beschaffungszeit und die Lieferzeiterrechnet und in der jeweiligen Bestellung gespeichert werden müssen. Irgendwann muss auch das Lager wieder aufgefüllt werden.

Erstellen Sie die Testklasse für Ihre Fabrik so, dass mehrere Bestellungen aufgegeben und die Auftragsbestätigungen überprüft werden können. Testen Sie auch, ob das Lager eine Bestellung an den Lieferanten senden kann.

Punkte: 10

Abgabedatum: 13.11.2022 (23:59 CET)

Einzureichen:

    - Implementierter und funktionsfähiger Code
    - Testklasse
    - Ein zip File mit Ihrem gesamten BlueJ Projekt

Bewertungskriterien:

    - Die Qualität Ihrer Codeimplementierung – Strukturierung, Benennung, Kommentare, Fehlerbehandlung – 2 Punkte
    - Die richtige Funktionsweise des implementierten Codes – 5 Punkte
    - Genügend Abdeckung der implementierten Tests, um die Funktionalität des Codes vollständig überprüfen zu können – 3 Punkte
