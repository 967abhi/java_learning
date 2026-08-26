# Iterable & Iterator in Java — Simple Bhasha Notes

> Ek line me: **Iterable = "mujhe ghumaya ja sakta hai"**, **Iterator = "wo banda jo ghumata hai"**.

---

## 1. Sabse pehle — problem kya thi?

Maan lo tumhare paas 4 alag-alag cheezein hain jisme data pada hai:

```java
int[] arr              = {10, 20, 30};
ArrayList<Integer> al  = ...;
LinkedList<Integer> ll = ...;
HashSet<Integer> hs    = ...;
```

Har ek ki **andar ki banawat (internal structure) alag hai**:

| Collection | Andar kya hai |
|---|---|
| Array | ek continuous memory block, index se access |
| ArrayList | andar array hi hai, par auto-grow karta hai |
| LinkedList | node -> node -> node, har node me next ka address |
| HashSet | hash table (buckets), koi index hi nahi |

Ab sawaal: **ek hi tarike se sabko ghumna (traverse) kaise ho?**

Agar Java ye na deta, to tumhe likhna padta:
- array ke liye -> `for(int i=0; i<arr.length; i++)`
- linked list ke liye -> `while(node != null) node = node.next;`
- hashset ke liye -> bucket-by-bucket ghumna

Yahi problem solve karta hai **Iterator**.

---

## 2. Iterator kya hai? (lame language)

Iterator ek **"pointer / ungli" jaisa object** hai jo collection ke upar chalta hai.
Usko sirf 2 cheez aati hai:

```java
boolean hasNext();  // "aage abhi koi element bacha hai kya?"
E       next();     // "haan, to wo element de do — aur ungli aage badha do"
```

Bas itna hi. Wo andar kaise ghum raha hai (array index se ya node ke `next` se) —
**tumhe pata hone ki zaroorat hi nahi**. Isko bolte hain **abstraction**.

```java
Iterator<Integer> it = list.iterator();
while (it.hasNext()) {
    System.out.println(it.next());
}
```

Ye code **ArrayList, LinkedList, HashSet — teeno pe same chalega**. Yahi power hai.

### Dhyaan do: `next()` do kaam karta hai
1. current element return karta hai
2. pointer ko ek step aage badha deta hai

Isliye **ek loop iteration me `next()` do baar mat likhna** — wo do element kha jaayega.
(Tumhare `Demo3.java` me yahi galti hai — neeche point 8 me detail hai.)

---

## 3. Iterable kya hai?

`Iterable` ek interface hai jisme bas **ek** main method hai:

```java
public interface Iterable<T> {
    Iterator<T> iterator();   // "mera ghumane wala banda le lo"
}
```

To relation aisa hai:

```
Iterable  --.iterator()-->  Iterator  --hasNext()/next()-->  elements
 (dukaan)                    (salesman)                       (saamaan)
```

- **Iterable** = wo cheez jise ghuma sakte ho (ArrayList, HashSet, tumhara custom class)
- **Iterator** = wo object jo actually ghumata hai

Jo bhi class `Iterable` implement karti hai, uspe **for-each loop chal jaata hai**. Bas.

---

## 4. Poora Family Tree

```
              Iterable  (interface)
                  |
              Collection  (interface)
        +---------+----------+
      List       Set       Queue
        |         |
   ArrayList   HashSet
   LinkedList  TreeSet
```

**Important baatein:**
- `Map` (HashMap) `Iterable` **nahi** hai! Isiliye `for(x : map)` nahi chalta.
  Uske liye `map.entrySet()` / `map.keySet()` pe loop lagate ho — wo Set hai, aur Set Iterable hai.
- **Array bhi `Iterable` nahi hai!** (`int[]` ek object hai par Iterable interface implement nahi karta)
  Fir `for(int x : arr)` kaise chalta hai? -> Point 6 dekho.

---

## 5. for-each loop = Iterator ka shortcut

Ye do code **bilkul same** hain (compiler khud convert karta hai):

```java
// tum likhte ho:
for (String name : container) {
    System.out.println(name);
}

// compiler banata hai:
Iterator<String> it = container.iterator();
while (it.hasNext()) {
    String name = it.next();
    System.out.println(name);
}
```

Isliye **for-each sirf tabhi chalega jab class `Iterable` implement kare**.
Tumhare `Demo2.java` me `NameContainer implements Iterable<String>` hai — isliye
`for(String name : container)` chal gaya.

---

## 6. Array ka special case

Array `Iterable` nahi hai, phir bhi for-each chalta hai —
kyunki **compiler array ke liye alag code banata hai** (special treatment):

```java
// tum likhte ho:
for (int x : arr) { ... }

// compiler banata hai (index loop, koi Iterator nahi):
for (int i = 0; i < arr.length; i++) {
    int x = arr[i];
    ...
}
```

**Isliye array pe ye nahi hota:**
```java
arr.iterator();   // ERROR — array me aisa method hai hi nahi
```

Array ko Iterable banane ke 2 tarike:
```java
// 1. List me convert karo
List<String> list = Arrays.asList(names);
Iterator<String> it = list.iterator();   // chal gaya

// 2. Ya apna wrapper class banao — jaise tumne Demo2 me kiya
```

---

## 7. Apna khud ka Iterable banana (Demo2.java samjho)

Tumhara code:

```java
class NameContainer implements Iterable<String> {
    private String[] names;
    private int size;

    NameContainer(String[] names) {
        this.names = names;
        this.size  = names.length;
    }

    @Override
    public Iterator<String> iterator() {
        return new NameContainerIterator();   // har baar NAYA iterator
    }

    private class NameContainerIterator implements Iterator<String> {
        private int pos = 0;                  // ye "ungli" hai

        @Override
        public boolean hasNext() {
            return pos < size;
        }

        @Override
        public String next() {
            return names[pos++];              // de do, aur ungli aage
        }
    }
}
```

### Line-by-line kya ho raha hai

1. `implements Iterable<String>` -> "mai ghumaya ja sakta hu, aur mere andar String hai"
2. `iterator()` -> jab bhi koi ghumna chahe, ek **fresh** iterator (`pos = 0`) de do
3. `NameContainerIterator` **inner class** hai -> isko bahar wale class ka
   `names` aur `size` directly dikhta hai (yahi inner class ka fayda)
4. `pos` iterator ke andar hai, container ke andar **nahi** -> isliye
   do log ek saath alag-alag speed se ghum sakte hain:

```java
Iterator<String> a = container.iterator();  // a ka pos = 0
Iterator<String> b = container.iterator();  // b ka alag pos = 0
a.next();  // "Abhishek"  (a ka pos = 1)
b.next();  // "Abhishek"  (b ka pos = 1, a se koi lena dena nahi)
```

### Agar `pos` container me hota to? (tumhare Demo3 wale comments ka answer)

Ye wahi `MyArrayList` example hai jo tumne notes me likha tha:

```java
class MyArrayList {
    int[] ar = {10, 20, 30};
    int size = 3;
    private int pos = 0;     // GALAT jagah — pos yaha nahi hona chahiye

    boolean hasNext() { return pos < size; }
    int next()        { return ar[pos++]; }
    void reset()      { pos = 0; }   // manually reset karna padega
}
```

Problem:
```java
MyArrayList l = new MyArrayList();
while (l.hasNext()) { ... }   // pos ab 3 ho gaya
while (l.hasNext()) { ... }   // chalega hi nahi — pos already 3 hai
l.reset();                    // har baar yaad se reset karna padega
```

Aur **nested loop** to bilkul toot jaayega — dono loop same `pos` share karenge:
```java
while (l.hasNext()) {
    int a = l.next();
    while (l.hasNext()) {     // ye andar wala poora pos kha jaayega
        int b = l.next();
        System.out.println(a + " " + b);
    }
}
// chahiye tha: 10-20, 10-30, 20-30
// milega:      10-20, 10-30   aur phir bahar wala loop khatam (pos = 3)
```

Ab dekho jab `pos` **Iterator** me hai to same nested loop sahi chalta hai:
```java
Iterator<String> i = container.iterator();
while (i.hasNext()) {
    String a = i.next();
    Iterator<String> j = container.iterator();  // NAYA iterator, apna alag pos
    while (j.hasNext()) {
        String b = j.next();
        System.out.println(a + " " + b);        // sahi combinations
    }
}
```

**Isliye Java ne `pos` ko alag class (Iterator) me daala.**
Ye hai **Separation of Concerns**:
- `Iterable` ka kaam -> **data rakhna**
- `Iterator` ka kaam -> **traversal ki state (position) rakhna**

---

## 8. ConcurrentModificationException (Demo3.java ka bug)

Tumhara current code:

```java
Iterator<Integer> it = list.iterator();
while (it.hasNext()) {
    int value = it.next();
    if (value == 30) {
        list.remove(value);              // BUG 2 — CME
    }
    System.out.println(it.next());       // BUG 1 — next() do baar
}
```

### Isme 3 alag bugs hain:

**Bug 1 — `next()` do baar**
Ek iteration me `next()` 2 baar call ho raha hai -> ek element skip ho raha hai,
aur end me `NoSuchElementException` aayega.
Fix: `next()` ek hi baar, value variable me store karke use karo.

**Bug 2 — loop ke andar `list.remove()` -> `ConcurrentModificationException`**

**Bug 3 — `list.remove(value)` galat method call kar raha hai** (neeche detail)

### CME hota kyun hai? (asli mechanism)

ArrayList ke andar ek counter hota hai: **`modCount`**
-> "list kitni baar structurally change hui" (add / remove kitni baar hua).

Jab tum `list.iterator()` call karte ho, iterator uski **photo copy** rakh leta hai:
```java
int expectedModCount = modCount;   // iterator ke andar
```

Ab har `next()` call pe iterator check karta hai:
```java
if (modCount != expectedModCount)
    throw new ConcurrentModificationException();
```

To flow aisa hai:
```
list.iterator()      ->  expectedModCount = 5, modCount = 5      OK
list.remove(...)     ->  modCount = 6, expectedModCount abhi bhi 5
it.next()            ->  6 != 5  ->  ConcurrentModificationException
```

Iterator bolta hai: *"bhai, mai jis list ko ghum raha tha wo beech me badal di gayi,
ab mera `pos` galat ho gaya — mai aage nahi jaunga."*

Isko bolte hain **fail-fast** — galti hote hi turant crash, chupchap galat output nahi.
(Ulta hota hai **fail-safe** — jaise `CopyOnWriteArrayList`, jo copy pe kaam karta hai
aur exception nahi deta, par purana snapshot dikhata hai.)

### Bug 3 — `remove(int)` vs `remove(Object)`

```java
list.remove(value);   // value ek `int` hai
```

`List<Integer>` me `remove()` ke 2 version hain:
- `remove(int index)`  -> **index** se hataata hai
- `remove(Object o)`   -> **value** se hataata hai

`value` `int` hai -> Java `remove(int index)` wala chunega ->
ye **index 30** hataane ki koshish karega -> `IndexOutOfBoundsException`!

Value se hataana ho to:
```java
list.remove(Integer.valueOf(30));   // ab value 30 hategi
```

### Sahi tarike (3 options)

**Option 1 — `it.remove()` (best, iterator ka apna remove)**
```java
Iterator<Integer> it = list.iterator();
while (it.hasNext()) {
    int value = it.next();
    if (value == 30) {
        it.remove();       // modCount aur expectedModCount dono update karta hai
    } else {
        System.out.println(value);
    }
}
```
`it.remove()` andar se ye karta hai:
```java
list.remove(lastReturnedIndex);
expectedModCount = modCount;   // dono ko sync kar deta hai — isliye CME nahi
```
**Rule: `it.remove()` hamesha `it.next()` ke baad hi call karo** (warna `IllegalStateException`).

**Option 2 — `removeIf()` (Java 8+, sabse chhota)**
```java
list.removeIf(value -> value == 30);
list.forEach(System.out::println);
```

**Option 3 — ulta index loop**
```java
for (int i = list.size() - 1; i >= 0; i--) {
    if (list.get(i) == 30) list.remove(i);
}
```
Ulta isliye — aage se hataane pe baaki elements left shift ho jaate hain aur index gadbad ho jaata hai.

---

## 9. Iterator ka 3rd method — `remove()`

```java
public interface Iterator<E> {
    boolean hasNext();
    E       next();
    default void remove() {         // optional — default me exception phekta hai
        throw new UnsupportedOperationException("remove");
    }
}
```

- Ye **optional** hai — har iterator isko support nahi karta
- `Arrays.asList(...)` ka iterator `remove()` support **nahi** karta (fixed size list)
- Tumhare `NameContainerIterator` me bhi override nahi kiya -> call karoge to `UnsupportedOperationException`

---

## 10. ListIterator — Iterator ka bada bhai (sirf List ke liye)

```java
ListIterator<Integer> lit = list.listIterator();

while (lit.hasNext()) {
    int v = lit.next();
    if (v == 30) lit.set(99);      // element badal do
    if (v == 20) lit.add(25);      // beech me naya daal do
}

// ULTA bhi ghum sakte ho
while (lit.hasPrevious()) {
    System.out.println(lit.previous());
}
```

| Feature | `Iterator` | `ListIterator` |
|---|---|---|
| Aage ghumna | haan | haan |
| Peeche ghumna | nahi | haan (`hasPrevious()` / `previous()`) |
| Element hataana | haan (`remove()`) | haan |
| Element badalna | nahi | haan (`set()`) |
| Element daalna | nahi | haan (`add()`) |
| Index milna | nahi | haan (`nextIndex()` / `previousIndex()`) |
| Kaha chalta hai | har Collection | **sirf List** |

---

## 11. Alag-alag collections ka iteration order

```java
List<Integer> list = new ArrayList<>();      // 10,20,30 -> 10,20,30  (insertion order)
List<Integer> ll   = new LinkedList<>();     // 10,20,30 -> 10,20,30  (insertion order)
Set<Integer>  hs   = new HashSet<>();        // 10,20,30 -> koi bhi order (hash pe depend)
Set<Integer>  lhs  = new LinkedHashSet<>();  // 10,20,30 -> 10,20,30  (insertion order)
Set<Integer>  ts   = new TreeSet<>();        // 30,10,20 -> 10,20,30  (sorted)
```

Tumhare `Deom.java` me `HashSet` use hua hai — chhote Integers ke liye order
sanyog se sorted lag sakta hai, par **guarantee bilkul nahi hai**. HashSet pe kabhi
order ka bharosa mat karna.

Ek aur baat `Deom.java` se: tumne `Collection<Integer> list = new HashSet<>();` likha hai.
Ye bilkul sahi practice hai — **variable ko interface type do, object ko concrete type**.
Isse kal ko `HashSet` ko `ArrayList` banana ho to sirf ek line badlegi, baaki iteration
code same rahega (kyunki dono ke peeche `Iterable` hai).

---

## 12. Map ko kaise ghumaye (Map Iterable nahi hai)

```java
Map<String, Integer> map = new HashMap<>();
map.put("a", 1);
map.put("b", 2);

// key + value dono (best tarika)
for (Map.Entry<String, Integer> e : map.entrySet()) {
    System.out.println(e.getKey() + " = " + e.getValue());
}

// sirf keys
for (String k : map.keySet()) { ... }

// sirf values
for (Integer v : map.values()) { ... }
```
`entrySet()`, `keySet()`, `values()` — ye sab **Collection** return karte hain, aur
Collection `Iterable` hai. Isiliye chalta hai.

---

## 13. Generics ka role (tum abhi `generics` branch pe ho)

```java
Iterator it = list.iterator();          // raw — sab kuch Object
Object o = it.next();
int x = (Integer) o;                    // manual cast, runtime crash ka risk

Iterator<Integer> it = list.iterator(); // typed
int x = it.next();                      // auto-unbox, compile-time safe
```

`Iterable<String>` implement karne ka matlab: `iterator()` ko `Iterator<String>`
return karna hoga, aur `next()` ko `String` return karna hoga.
Compiler khud check kar lega — galti compile time pe hi pakdi jaayegi, runtime pe nahi.

---

## 14. Ek chhota complete example (sab kuch ek jagah)

```java
package Interable;

import java.util.*;

public class IterableFullDemo {

    public static void main(String[] args) {

        // ---- 1. Custom Iterable pe for-each ----
        NumberBox box = new NumberBox(new int[]{5, 10, 15, 20});
        for (int n : box) System.out.print(n + " ");    // 5 10 15 20
        System.out.println();

        // ---- 2. Do independent iterator ----
        Iterator<Integer> a = box.iterator();
        Iterator<Integer> b = box.iterator();
        System.out.println(a.next() + " " + b.next());  // 5 5  (dono ka alag pos)

        // ---- 3. Safe removal ----
        List<Integer> list = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            if (it.next() == 30) it.remove();           // CME nahi aayega
        }
        System.out.println(list);                       // [10, 20, 40, 50]

        // ---- 4. CME dikhane ke liye (jaan-boojh ke galat code) ----
        try {
            for (Integer v : list) {
                if (v == 20) list.remove(Integer.valueOf(20));
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("CME aa gaya: " + e);
        }
    }
}

class NumberBox implements Iterable<Integer> {
    private final int[] data;

    NumberBox(int[] data) { this.data = data; }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {        // anonymous inner class
            private int pos = 0;

            @Override
            public boolean hasNext() { return pos < data.length; }

            @Override
            public Integer next() {
                if (!hasNext()) throw new NoSuchElementException();  // proper behaviour
                return data[pos++];
            }
        };
    }
}
```

---

## 15. Yaad rakhne wali baatein (cheat sheet)

| # | Baat |
|---|---|
| 1 | `Iterable` = ghumaya ja sakta hai. `Iterator` = ghumane wala. |
| 2 | `Iterable` me 1 method: `iterator()`. `Iterator` me 2 main: `hasNext()`, `next()` (+ optional `remove()`) |
| 3 | for-each loop andar se Iterator hi use karta hai |
| 4 | Array `Iterable` nahi hai — compiler use index-loop me badal deta hai |
| 5 | Map `Iterable` nahi hai — `entrySet()` / `keySet()` pe loop lagao |
| 6 | `next()` ek iteration me **sirf ek baar** call karo |
| 7 | `pos` hamesha **Iterator** me rakho, Iterable me nahi (separation of concerns) |
| 8 | `iterator()` har baar **naya** iterator return kare (`pos = 0`) |
| 9 | Loop ke andar `list.add()` / `list.remove()` = **ConcurrentModificationException** |
| 10 | CME ka reason: `modCount != expectedModCount` (fail-fast) |
| 11 | Loop me hataana ho to `it.remove()` ya `list.removeIf()` use karo |
| 12 | `it.remove()` hamesha `it.next()` ke baad |
| 13 | `List<Integer>.remove(30)` = index 30 hataayega, value 30 nahi! `Integer.valueOf(30)` use karo |
| 14 | Ulta ghumna / set / add chahiye -> `ListIterator` (sirf List pe) |
| 15 | `HashSet` ka order guaranteed nahi hota |

---

## 16. Interview me pooche jaane wale sawaal

**Q: `Iterable` aur `Iterator` me farak?**
A: `Iterable` wo collection hai jo ghumaya ja sakta hai (ek method `iterator()`).
`Iterator` wo object hai jo actual traversal karta hai aur position (state) rakhta hai.
Ek Iterable se kai independent Iterator ban sakte hain.

**Q: `Enumeration` aur `Iterator` me farak?**
A: `Enumeration` purana hai (Java 1.0, `Vector` / `Hashtable` ke liye) —
`hasMoreElements()` / `nextElement()`. Usme `remove()` nahi hai.
`Iterator` naya hai, `remove()` deta hai, naam chhote hain. Ab hamesha Iterator use karo.

**Q: fail-fast vs fail-safe?**
A: **fail-fast** (ArrayList, HashMap) -> beech me modify kiya to turant `ConcurrentModificationException`.
**fail-safe** (`CopyOnWriteArrayList`, `ConcurrentHashMap`) -> copy / snapshot pe ghumta hai,
exception nahi deta, par latest changes nahi dikhte.

**Q: for-each me element kyun remove nahi kar sakte?**
A: for-each me iterator object chhupa hua hai, tumhare paas uska reference hai hi nahi —
isliye `remove()` / `set()` call nahi kar sakte. Uske liye explicit `Iterator` ya `ListIterator` chahiye.

**Q: `NoSuchElementException` kab aata hai?**
A: Jab `hasNext()` false hone ke baad bhi `next()` call kar do —
jaise ek loop iteration me `next()` do baar call karna (tumhare Demo3 wala case).

**Q: Ek Iterator ko dobara use kar sakte ho?**
A: Nahi. Iterator **one-way, one-time** hai. Poora ghum liya to khatam.
Dobara ghumna ho to `collection.iterator()` se naya banao.
