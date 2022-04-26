package cyc.Containers;

import cyc.Utils;

import java.util.*;

public class Exercise20 {

   static class SimpleHashMap2<K,V>extends AbstractMap<K,V> {

        static final int SIZE = 997;

        LinkedList<Utils.MapEntry<K, V>>[] buckets =
                new LinkedList[SIZE];

        public V put(K key, V value) {
            V oldValue = null;
            int index = Math.abs(key.hashCode()) % SIZE;
            if (buckets[index] == null)
                buckets[index] = new LinkedList<>();

            LinkedList<Utils.MapEntry<K, V>> bucket = buckets[index];
            Utils.MapEntry<K, V> pair = new Utils.MapEntry<>(key, value);
            boolean found = false;
            ListIterator<Utils.MapEntry<K, V>> listIterator = bucket.listIterator();
            while (listIterator.hasNext()) {
                Utils.MapEntry<K, V> iPair = listIterator.next();
                if (iPair.getKey().equals(key)) {
                    oldValue = iPair.getValue();
                    System.out.println("Collision: new " +
                            pair + " for old " + iPair);
                    listIterator.set(pair);// replace the old with the new
                    found = true;
                    break;
                }
            }
            if (!found) {
                bucket.add(pair);
            }
            return oldValue;
        }

        public V get(Object key) {
            int index = Math.abs(key.hashCode()) % SIZE;
            if (buckets[index] == null) return null;
            for (Utils.MapEntry<K, V> mapEntry : buckets[index]) {
                if (mapEntry.getKey().equals(key))
                    return mapEntry.getValue();
            }
            return null;
        }

        @Override
        public Set<Entry<K, V>> entrySet() {
            Set<Entry<K, V>> set = new HashSet<>();
            for (LinkedList<Utils.MapEntry<K, V>> bucket : buckets) {
                if (bucket == null) continue;
                for (Utils.MapEntry<K, V> mapEntry : bucket)
                    set.add(mapEntry);
            }
            return set;
        }
    }
    public static void main(String[]args)
    {

    }
}
