package binaryTrees

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import kotlin.random.Random

class BinarySearchTreeTest {

    private fun randomBinarySearchTree(size: Int): BinarySearchTree<Int, Int> {
        val tree = BinarySearchTree<Int, Int>()

        for (i in 1..size) {
            tree.insert(Random.Default.nextInt(), Random.Default.nextInt())
        }

        return tree
    }

    @Test
    fun basicTest() {
        val tree = BinarySearchTree<Int, Int>()

        for (i in 1..5) {
            tree.insert(i, i * i)
        }

        for (i in 1..5) {
            assertEquals(tree.find(i), i * i)
        }

        assertEquals(tree.find(6), null)
    }

    @Test
    fun correctnessTest() {
        for (i in 1..10) {
            val tree = randomBinarySearchTree(Random.Default.nextInt(0, 10))
            assert(tree.isBinarySearchTree())
        }
    }

    @Test
    fun stressTest() {
        val tree = randomBinarySearchTree(1000)
        assert(tree.isBinarySearchTree())
    }

    @Test
    fun insertExistingKey() {
        val tree = BinarySearchTree<Int, Int>()

        for (i in 1..5){
            tree.insert(i, i*i)
        }

        tree.insert(3, 10)
        assertEquals(tree.find(3), 10)
    }

    @Test
    fun differentKeyEqualValueTest(){
        val tree = BinarySearchTree<Int, Int>()
        val firstNode = tree.Node(3, 4, null)
        val secondNode = tree.Node(5, 4, firstNode)

        assertNotEquals(firstNode, secondNode)
    }

    @Test
    fun equalityNodesWithEqualKeyValueTest(){
        val tree = BinarySearchTree<Int, Int>()
        val firstNode = tree.innerInsert(5, 4)
        val secondNode = tree.innerInsert(5, 4)

        assertEquals(firstNode, secondNode)
    }

    @Test
    fun equalityNodesTest(){
        val tree = BinarySearchTree<Int, Int>()
        val root = tree.innerInsert(5, 3)
        val rightSon = tree.innerInsert(6, 7)
        val leftSon = tree.innerInsert(4, 10)

        assertEquals(root.right , rightSon)
        assertEquals(root.left, leftSon)
        assertEquals(root, leftSon.parent)
        assertEquals(root, leftSon.parent)
    }
}