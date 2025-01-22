package PathPlanning;

import java.util.*;

class HuffmanNode {
    char ch;
    int freq;
    HuffmanNode left, right;

    public HuffmanNode(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
        this.left = this.right = null;
    }
}

public class HuffmanCoding {
    public static void main(String[] args) {
        String text = "huffman coding example"; // 输入文本

        // 步骤 1: 统计频率
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char ch : text.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        // 步骤 2: 构建优先队列
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.freq));
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            pq.offer(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        // 步骤 3: 构建赫夫曼树
        while (pq.size() > 1) {
            HuffmanNode left = pq.poll();
            HuffmanNode right = pq.poll();
            HuffmanNode newNode = new HuffmanNode('\0', left.freq + right.freq);
            newNode.left = left;
            newNode.right = right;
            pq.offer(newNode);
        }
        HuffmanNode root = pq.poll();

        // 步骤 4: 生成赫夫曼编码
        Map<Character, String> huffmanCodeMap = new HashMap<>();
        generateCodes(root, "", huffmanCodeMap);
        System.out.println("Huffman Codes: " + huffmanCodeMap);

        // 步骤 5: 编码
        StringBuilder encodedText = new StringBuilder();
        for (char ch : text.toCharArray()) {
            encodedText.append(huffmanCodeMap.get(ch));
        }
        System.out.println("Encoded Text: " + encodedText);

        // 步骤 6: 解码
        StringBuilder decodedText = new StringBuilder();
        HuffmanNode currentNode = root;
        for (char bit : encodedText.toString().toCharArray()) {
            currentNode = (bit == '0') ? currentNode.left : currentNode.right;
            if (currentNode.left == null && currentNode.right == null) {
                decodedText.append(currentNode.ch);
                currentNode = root;
            }
        }
        System.out.println("Decoded Text: " + decodedText);
    }

    private static void generateCodes(HuffmanNode node, String code, Map<Character, String> huffmanCodeMap) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            huffmanCodeMap.put(node.ch, code);
        }
        generateCodes(node.left, code + "0", huffmanCodeMap);
        generateCodes(node.right, code + "1", huffmanCodeMap);
    }
}
