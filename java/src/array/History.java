package array;

class HistoryNode {

    String url;
    HistoryNode prev = null;
    HistoryNode next = null;

    public HistoryNode(String url) {
        this.url = url;
    }

    public HistoryNode(String url, HistoryNode prev) {
        this.url = url;
        this.prev = prev;
    }

}

class History {

    HistoryNode current;

    public History(String url) {
        current = new HistoryNode(url);
    }

    public void visit(String url) {
        current.next = new HistoryNode(url, current);
        current = current.next;
    }

    public String back(int steps) {
        while(steps > 0 && current.prev != null) {
            steps -= 1;
            current = current.prev;
        }

        return current.url;
    }

    public String forward(int steps) {
        while(steps > 0 && current.next != null) {
            steps -= 1;
            current = current.next;
        }

        return current.url;
    }

    public static void main(String[] args) {

        History history = new History("www.naver.com");
        history.visit("www.google.com");
        history.visit("www.kakao.com");
        history.visit("www.toss.com");

        System.out.println(history.back(1));
        System.out.println(history.back(2));
    }

}