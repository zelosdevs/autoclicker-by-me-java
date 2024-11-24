# AutoClicker

AutoClicker egy egyszerű Java alkalmazás, amely lehetővé teszi az egér automatikus kattintásainak szimulálását. Ez az alkalmazás különösen hasznos ismétlődő műveletek automatizálására, például játékokban, tesztelési folyamatok során, vagy bármilyen más tevékenységhez, amely sok kattintást igényel.

## Jellemzők
- **Automatikus kattintások**: A bal egérgomb folyamatos kattintásának szimulálása.
- **Testreszabható CPS (Clicks Per Second)**: Állítható kattintási sebesség véletlenszerű tartományban.
- **Egyszerű vezérlés**: Az F6 billentyű segítségével be- és kikapcsolható.
- **Futás a háttérben**: Minimalizált CPU használat, miközben folyamatosan működik.

## Követelmények
- **Java 8** vagy újabb verzió
- **Maven** (a `jnativehook` könyvtár telepítéséhez)

## Telepítés
1. **Clone-olja a projektet**:
   Nyisd meg a terminált, és futtasd:
   ```bash
   git clone https://github.com/zelosdevs/autoclicker-by-me-java.git
   cd autoclicker
