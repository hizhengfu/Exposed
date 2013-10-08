package kotlin.sql.tests.h2

import kotlin.test.assertEquals

private fun<T> assertEqualCollectionsImpl(collection : Collection<T>, expected : Collection<T>) {
    assertEquals (expected.size, collection.size(), "Count mismatch")
    for (p in collection) {
        assert(expected.any {it.equals(p)}, "Unexpected element in collection pair $p")
    }
}

fun<T> assertEqualCollections (collection : Collection<T>, expected : Collection<T>) {
    assertEqualCollectionsImpl(collection, expected)
}

fun<T> assertEqualCollections (collection : Collection<T>, vararg expected : T) {
    assertEqualCollectionsImpl(collection, expected.toList())
}

fun<T> assertEqualCollections (collection : Iterable<T>, vararg expected : T) {
    assertEqualCollectionsImpl(collection.toList(), expected.toList())
}

fun<T> assertEqualCollections (collection : Iterable<T>, expected : Collection<T>) {
    assertEqualCollectionsImpl(collection.toList(), expected)
}

fun<T> assertEqualLists (l1: List<T>, l2: List<T>) {
    assertEquals(l1.size, l2.size, "Count mismatch")
    for (i in 0..l1.size-1)
        assertEquals(l1[i], l2[i], "Error at pos $i:")
}

fun<T> assertEqualLists (l1: List<T>, vararg expected : T) {
    assertEqualLists(l1, expected.toList())
}