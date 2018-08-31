public class EncodeDecode {
    List<List<String>> list = new LinkedList<List<String>>();

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        list.add(strs);
        return Integer.toString(list.size() - 1);
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        return list.get(Integer.parseInt(s));
    }
}
