Aufgabe 1 – Implementierung 1 (10 Punkte)

Als Grundlage für diese Implementierungsaufgabe stehen Ihnen die Musterlösung des Klassendiagramms für diese Teilaufgabe und ein ausgewähltes Sequenzdiagramme zur Verfügung. Versuchen Sie diese Diagramme zu verstehen, denn sie dienen als Grundlage für Ihre erste Programmieraufgabe.

In der Implementierung möchten wir, dass Sie eine Klasse Fabrik implementieren, die Bestellungen entgegennimmt und diese auf der Konsole ausgibt. Die Klasse Fabrik enthält als globale Variable eine ArrayList in der alle Bestellungen gespeichert werden. Mit der Methode bestellungAufgeben ist es möglich eine neue Bestellung zu platzieren, in der die Anzahl bestellter Stühle und Sofas angegeben werden. Die Methode bestellungenAusgebendurchläuft die Liste der Bestellungen und gibt jeweils die Information zu den einzelnen Bestellungen auf der Konsole aus. Die Klasse Fabrik enthält die Methode main, die den Einstieg in das Programm ermöglicht.

Die Klasse Bestellung verwaltet eine ArrayList, in der alle bestellten Produkte gespeichert werden. Produkte können entweder Stühle oder Sofas sein. Als globale Variablen enthält die Klasse Bestellung die Bestellbestätigung, Beschaffungszeit, Bestellnummer, wie auch die Anzahl bestellter Stühle und die Anzahl bestellter Sofas. Zu jeder globalen Variablen muss jeweils eine Methode implementiert werden, um die Information abzufragen. Bei gewissen globalen Variablen muss auch eine Methode vorhanden sein, um die Information in den Variablen zu ändern.

Die Klassen Stuhl und Sofa sind Erweiterungen von der Klasse Produkt und erben somit die Funktionalität und die globalen Variablen der Klasse Produkt. Jedes Produkt befindet sich in einem gewissen Zustand, beispielsweise bestellt, in Produktion etc.. Dieser könnte auch in einer globalen Variablen abgespeichert werden. Für die Klasse Stuhl und Sofa ist Information vorhanden, die für alle Instanzen dieser Klassen gleich ist. Beispielsweise wären das die Anzahl Holzeinheiten, Anzahl Schrauben, etc. Auch die Methoden, um auf diese Information zuzugreifen, gehören der Klasse an und nicht den einzelnen Instanzen.

Natürlich sind noch weitere Methoden und Variablen notwendig, um das Programm zum Laufen zu bringen. Auch eine Testklasse für die Fabrik wird benötigt, um Bestellungen aufzugeben und die bestellten Produkte ausgeben. 
------------------------------------------------------------------------

Punkte: 10

Abgabedatum: 30.10.2022 (23:59 CET)

Einzureichen:

    Implementierter und funktionsfähiger Code
    Testklasse
    Ein zip File mit Ihrem gesamten BlueJ Projekt

Bewertungskriterien:

    Die Qualität Ihrer Codeimplementierung – Strukturierung, Benennung, Kommentare, Fehlerbehandlung – 2 Punkte
    Die richtige Funktionsweise des implementierten Codes – 5 Punkte
    Genügend Abdeckung der implementierten Tests, um die Funktionalität des Codes vollständig überprüfen zu können – 3 Punkte
