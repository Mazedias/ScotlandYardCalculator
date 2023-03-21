package model.graph.util;


import model.game.transportation.TransportationType;
import model.util.exceptions.InvalidNode;

import java.util.Arrays;
import java.util.List;

public class GraphBuilder {

    private final Graph graph;

    public GraphBuilder(String name) {
        this.graph = new Graph(name);
    }

    /**
     * Builds the graph with {@link GraphBuilder#addNodes()} and {@link GraphBuilder#addEdges()}
     * @return Returns the graph or null
     */
    public Graph build() {
        this.addNodes();
        try {
            this.addEdges();
        } catch (InvalidNode e) {
            e.printStackTrace();
            return null;
        }
        return this.graph;
    }

    private void addNodes() {
        int[] taxiStations = new int[]{2, 4, 5, 6, 8, 9, 10, 11, 12, 16, 17, 18, 19, 20, 21, 24, 25, 26, 27, 28, 30,
                31, 32, 33, 35, 36, 37, 38, 39, 40, 43, 44, 45, 47, 48, 49, 50, 51, 53, 54, 56,
                57, 59, 60, 61, 62, 64, 66, 68, 69, 70, 71, 73, 75, 76, 80, 81, 83, 84, 85, 88,
                90, 91, 92, 95, 96, 97, 98, 99, 101, 103, 104, 106, 109, 110, 112, 113, 114, 115,
                117, 118, 119, 120, 121, 125, 126, 129, 130, 131, 132, 134, 136, 137, 138, 139, 141,
                143, 145, 146, 147, 148, 149, 150, 151, 152, 155, 158, 159, 160, 162, 164, 166, 167,
                168, 169, 170, 171, 172, 173, 174, 175, 177, 178, 179, 181, 182, 183, 186, 188,
                189, 192, 193, 194, 195, 196, 197, 198};
        int[] busTaxiStations = new int[]{3, 7, 14, 15, 22, 23, 29, 34, 41, 42, 52, 55, 58, 63, 65, 72, 77, 78,
                82, 86, 87, 94, 100, 102, 105, 107, 108, 116, 122, 123, 124, 127, 133, 135, 142, 144,
                154, 156, 157, 161, 165, 176, 180, 184, 187, 190, 191, 199};
        int[] busSubwayTaxiStations = new int[]{1, 13, 46, 67, 74, 79, 89, 93, 111, 128, 140, 153, 163, 185};

        Arrays.stream(taxiStations).forEach(i -> this.graph.addNode(
                new Node(i, List.of(TransportationType.TAXI))));
        Arrays.stream(busTaxiStations).forEach(i -> this.graph.addNode(
                new Node(i, List.of(TransportationType.TAXI, TransportationType.BUS))));
        Arrays.stream(busSubwayTaxiStations).forEach(i -> this.graph.addNode(
                new Node(i, List.of(TransportationType.TAXI, TransportationType.BUS, TransportationType.SUBWAY))));
    }

    private void addEdges() throws InvalidNode {
        // Edges of node "1"
        this.addEdge(1,8, TransportationType.TAXI);
        this.addEdge(1,9, TransportationType.TAXI);
        this.addEdge(1,58, TransportationType.BUS);
        this.addEdge(1,46, TransportationType.BUS);
        this.addEdge(1,46, TransportationType.SUBWAY);

        // Edges of node "2"
        this.addEdge(2,10, TransportationType.TAXI);
        this.addEdge(2,20, TransportationType.TAXI);

        // Edges of node "3"
        this.addEdge(3,4, TransportationType.TAXI);
        this.addEdge(3,11, TransportationType.TAXI);
        this.addEdge(3,12, TransportationType.TAXI);
        this.addEdge(3,22, TransportationType.BUS);
        this.addEdge(3,23, TransportationType.BUS);

        // Edges of node "4"
        this.addEdge(4,13, TransportationType.TAXI);

        // Edges of node "5"
        this.addEdge(5, 16, TransportationType.TAXI);
        this.addEdge(5, 15, TransportationType.TAXI);

        // Edges of node "6"
        this.addEdge(6, 7, TransportationType.TAXI);
        this.addEdge(6, 29, TransportationType.TAXI);

        // Edges of node "7"
        this.addEdge(7, 17, TransportationType.TAXI);
        this.addEdge(7, 42, TransportationType.BUS);

        // Edges of node "8"
        this.addEdge(8, 18, TransportationType.TAXI);
        this.addEdge(8, 19, TransportationType.TAXI);

        // Edges of node "9"
        this.addEdge(9, 19, TransportationType.TAXI);
        this.addEdge(9, 20, TransportationType.TAXI);

        // Edges of node "10"
        this.addEdge(10, 11, TransportationType.TAXI);
        this.addEdge(10, 21, TransportationType.TAXI);
        this.addEdge(10, 34, TransportationType.TAXI);

        // Edges of node "11"
        this.addEdge(11, 22, TransportationType.TAXI);

        // Edges of node "12"
        this.addEdge(12, 23, TransportationType.TAXI);

        // Edges of node "13"
        this.addEdge(13, 23, TransportationType.TAXI);
        this.addEdge(13, 24, TransportationType.TAXI);
        this.addEdge(13, 14, TransportationType.BUS);
        this.addEdge(13, 23, TransportationType.BUS);
        this.addEdge(13, 52, TransportationType.BUS);
        this.addEdge(13, 46, TransportationType.SUBWAY);
        this.addEdge(13, 67, TransportationType.SUBWAY);
        this.addEdge(13, 89, TransportationType.SUBWAY);

        // Edges of node "14"
        this.addEdge(14, 15, TransportationType.TAXI);
        this.addEdge(14, 25, TransportationType.TAXI);
        this.addEdge(14, 15, TransportationType.BUS);

        // Edges of node "15"
        this.addEdge(15, 16, TransportationType.TAXI);
        this.addEdge(15, 26, TransportationType.TAXI);
        this.addEdge(15, 28, TransportationType.TAXI);
        this.addEdge(15, 41, TransportationType.BUS);
        this.addEdge(15, 29, TransportationType.BUS);

        // Edges of node "16"
        this.addEdge(16, 28, TransportationType.TAXI);
        this.addEdge(16, 29, TransportationType.TAXI);

        // Edges of node "17"
        this.addEdge(17, 29, TransportationType.TAXI);
        this.addEdge(17, 30, TransportationType.TAXI);

        // Edges of node "18"
        this.addEdge(18, 31, TransportationType.TAXI);
        this.addEdge(18, 43, TransportationType.TAXI);

        // Edges of node "19"
        this.addEdge(19, 32, TransportationType.TAXI);

        // Edges of node "20"
        this.addEdge(20, 33, TransportationType.TAXI);

        // Edges of node "21"
        this.addEdge(21, 33, TransportationType.TAXI);

        // Edges of node "22"
        this.addEdge(22, 23, TransportationType.TAXI);
        this.addEdge(22, 34, TransportationType.TAXI);
        this.addEdge(22, 35, TransportationType.TAXI);
        this.addEdge(22, 23, TransportationType.BUS);
        this.addEdge(22, 34, TransportationType.BUS);
        this.addEdge(22, 65, TransportationType.BUS);

        // Edges of node "23"
        this.addEdge(23, 37, TransportationType.TAXI);
        this.addEdge(23, 67, TransportationType.BUS);

        // Edges of node "24"
        this.addEdge(24, 37, TransportationType.TAXI);
        this.addEdge(24, 38, TransportationType.TAXI);

        // Edges of node "25"
        this.addEdge(25, 38, TransportationType.TAXI);
        this.addEdge(25, 39, TransportationType.TAXI);

        // Edges of node "26"
        this.addEdge(26, 27, TransportationType.TAXI);
        this.addEdge(26, 39, TransportationType.TAXI);

        // Edges of node "27"
        this.addEdge(27, 28, TransportationType.TAXI);
        this.addEdge(27, 40, TransportationType.TAXI);

        // Edges of node "28"
        this.addEdge(28, 41, TransportationType.TAXI);

        // Edges of node "29"
        this.addEdge(29, 41, TransportationType.TAXI);
        this.addEdge(29, 42, TransportationType.TAXI);
        this.addEdge(29, 41, TransportationType.BUS);
        this.addEdge(29, 42, TransportationType.BUS);
        this.addEdge(29, 55, TransportationType.BUS);

        // Edges of node "30"
        this.addEdge(30, 42, TransportationType.TAXI);

        // Edges of node "31"
        this.addEdge(31, 43, TransportationType.TAXI);
        this.addEdge(31, 44, TransportationType.TAXI);

        // Edges of node "32"
        this.addEdge(32, 33, TransportationType.TAXI);
        this.addEdge(32, 44, TransportationType.TAXI);
        this.addEdge(32, 45, TransportationType.TAXI);

        // Edges of node "33"
        this.addEdge(33, 46, TransportationType.TAXI);

        // Edges of node "34"
        this.addEdge(34, 47, TransportationType.TAXI);
        this.addEdge(34, 48, TransportationType.TAXI);
        this.addEdge(34, 46, TransportationType.BUS);
        this.addEdge(34, 63, TransportationType.BUS);

        // Edges of node "35"
        this.addEdge(35, 36, TransportationType.TAXI);
        this.addEdge(35, 48, TransportationType.TAXI);
        this.addEdge(35, 65, TransportationType.TAXI);

        // Edges of node "36"
        this.addEdge(36, 37, TransportationType.TAXI);
        this.addEdge(36, 49, TransportationType.TAXI);

        // Edges of node "37"
        this.addEdge(37, 50, TransportationType.TAXI);

        // Edges of node "38"
        this.addEdge(38, 50, TransportationType.TAXI);
        this.addEdge(38, 51, TransportationType.TAXI);

        // Edges of node "39"
        this.addEdge(39, 51, TransportationType.TAXI);
        this.addEdge(39, 52, TransportationType.TAXI);

        // Edges of node "40"
        this.addEdge(40, 41, TransportationType.TAXI);
        this.addEdge(40, 52, TransportationType.TAXI);
        this.addEdge(40, 53, TransportationType.TAXI);

        // Edges of node "41"
        this.addEdge(41, 54, TransportationType.TAXI);
        this.addEdge(41, 52, TransportationType.BUS);
        this.addEdge(41, 87, TransportationType.BUS);

        // Edges of node "42"
        this.addEdge(42, 56, TransportationType.TAXI);
        this.addEdge(42, 72, TransportationType.TAXI);
        this.addEdge(41, 72, TransportationType.BUS);

        // Edges of node "43"
        this.addEdge(43, 57, TransportationType.TAXI);

        // Edges of node "44"
        this.addEdge(44, 58, TransportationType.TAXI);

        // Edges of node "45"
        this.addEdge(45, 46, TransportationType.TAXI);
        this.addEdge(45, 58, TransportationType.TAXI);
        this.addEdge(45, 59, TransportationType.TAXI);
        this.addEdge(45, 60, TransportationType.TAXI);

        // Edges of node "46"
        this.addEdge(46, 47, TransportationType.TAXI);
        this.addEdge(46, 61, TransportationType.TAXI);
        this.addEdge(46, 58, TransportationType.BUS);
        this.addEdge(46, 78, TransportationType.BUS);
        this.addEdge(46, 74, TransportationType.SUBWAY);
        this.addEdge(46, 79, TransportationType.SUBWAY);

        // Edges of node "47"
        this.addEdge(47, 62, TransportationType.TAXI);

        // Edges of node "48"
        this.addEdge(48, 62, TransportationType.TAXI);
        this.addEdge(48, 63, TransportationType.TAXI);

        // Edges of node "49"
        this.addEdge(49, 50, TransportationType.TAXI);
        this.addEdge(49, 66, TransportationType.TAXI);

        // Edges of node "50"
        // -> All edges already added to graph

        // Edges of node "51"
        this.addEdge(51, 52, TransportationType.TAXI);
        this.addEdge(51, 67, TransportationType.TAXI);
        this.addEdge(51, 68, TransportationType.TAXI);

        // Edges of node "52"
        this.addEdge(52, 69, TransportationType.TAXI);
        this.addEdge(52, 67, TransportationType.BUS);
        this.addEdge(52, 87, TransportationType.BUS);

        // Edges of node "53"
        this.addEdge(53, 54, TransportationType.TAXI);
        this.addEdge(53, 69, TransportationType.TAXI);

        // Edges of node "54"
        this.addEdge(54, 55, TransportationType.TAXI);
        this.addEdge(54, 70, TransportationType.TAXI);

        // Edges of node "55"
        this.addEdge(55, 71, TransportationType.TAXI);
        this.addEdge(55, 89, TransportationType.BUS);

        // Edges of node "56"
        this.addEdge(56, 91, TransportationType.TAXI);

        // Edges of node "57"
        this.addEdge(57, 58, TransportationType.TAXI);
        this.addEdge(57, 73, TransportationType.TAXI);

        // Edges of node "58"
        this.addEdge(58, 59, TransportationType.TAXI);
        this.addEdge(58, 74, TransportationType.TAXI);
        this.addEdge(58, 75, TransportationType.TAXI);
        this.addEdge(58, 74, TransportationType.BUS);
        this.addEdge(58, 77, TransportationType.BUS);

        // Edges of node "59"
        this.addEdge(59, 75, TransportationType.TAXI);
        this.addEdge(59, 76, TransportationType.TAXI);

        // Edges of node "60"
        this.addEdge(60, 61, TransportationType.TAXI);
        this.addEdge(60, 76, TransportationType.TAXI);

        // Edges of node "61"
        this.addEdge(61, 62, TransportationType.TAXI);
        this.addEdge(61, 76, TransportationType.TAXI);
        this.addEdge(61, 78, TransportationType.TAXI);

        // Edges of node "62"
        this.addEdge(62, 79, TransportationType.TAXI);

        // Edges of node "63"
        this.addEdge(63, 64, TransportationType.TAXI);
        this.addEdge(63, 79, TransportationType.TAXI);
        this.addEdge(63, 80, TransportationType.TAXI);
        this.addEdge(63, 65, TransportationType.BUS);
        this.addEdge(63, 79, TransportationType.BUS);
        this.addEdge(63, 100, TransportationType.BUS);

        // Edges of node "64"
        this.addEdge(64, 65, TransportationType.TAXI);
        this.addEdge(64, 81, TransportationType.TAXI);

        // Edges of node "65"
        this.addEdge(65, 66, TransportationType.TAXI);
        this.addEdge(65, 82, TransportationType.TAXI);
        this.addEdge(65, 67, TransportationType.BUS);
        this.addEdge(65, 82, TransportationType.BUS);

        // Edges of node "66"
        this.addEdge(66, 67, TransportationType.TAXI);
        this.addEdge(66, 82, TransportationType.TAXI);

        // Edges of node "67"
        this.addEdge(67, 68, TransportationType.TAXI);
        this.addEdge(67, 84, TransportationType.TAXI);
        this.addEdge(67, 102, TransportationType.BUS);
        this.addEdge(67, 79, TransportationType.SUBWAY);
        this.addEdge(67, 89, TransportationType.SUBWAY);
        this.addEdge(67, 111, TransportationType.SUBWAY);

        // Edges of node "68"
        this.addEdge(68, 69, TransportationType.TAXI);
        this.addEdge(68, 85, TransportationType.TAXI);

        // Edges of node "69"
        this.addEdge(69, 86, TransportationType.TAXI);

        // Edges of node "70"
        this.addEdge(70, 71, TransportationType.TAXI);
        this.addEdge(70, 87, TransportationType.TAXI);

        // Edges of node "71"
        this.addEdge(71, 72, TransportationType.TAXI);
        this.addEdge(71, 89, TransportationType.TAXI);

        // Edges of node "72"
        this.addEdge(72, 90, TransportationType.TAXI);
        this.addEdge(72, 91, TransportationType.TAXI);
        this.addEdge(72, 105, TransportationType.BUS);
        this.addEdge(72, 107, TransportationType.BUS);

        // Edges of node "73"
        this.addEdge(73, 74, TransportationType.TAXI);
        this.addEdge(73, 92, TransportationType.TAXI);

        // Edges of node "74"
        this.addEdge(74, 75, TransportationType.TAXI);
        this.addEdge(74, 92, TransportationType.TAXI);
        this.addEdge(74, 94, TransportationType.BUS);

        // Edges of node "75"
        this.addEdge(75, 94, TransportationType.TAXI);

        // Edges of node "76"
        this.addEdge(76, 77, TransportationType.TAXI);

        // Edges of node "77"
        this.addEdge(77, 78, TransportationType.TAXI);
        this.addEdge(77, 95, TransportationType.TAXI);
        this.addEdge(77, 96, TransportationType.TAXI);
        this.addEdge(77, 78, TransportationType.BUS);
        this.addEdge(77, 94, TransportationType.BUS);
        this.addEdge(77, 124, TransportationType.BUS);

        // Edges of node "78"
        this.addEdge(78, 79, TransportationType.TAXI);
        this.addEdge(78, 97, TransportationType.TAXI);
        this.addEdge(78, 79, TransportationType.BUS);

        // Edges of node "79"
        this.addEdge(79, 98, TransportationType.TAXI);
        this.addEdge(79, 93, TransportationType.SUBWAY);
        this.addEdge(79, 111, TransportationType.SUBWAY);

        // Edges of node "80"
        this.addEdge(80, 99, TransportationType.TAXI);
        this.addEdge(80, 100, TransportationType.TAXI);

        // Edges of node "81"
        this.addEdge(81, 82, TransportationType.TAXI);
        this.addEdge(81, 100, TransportationType.TAXI);

        // Edges of node "82"
        this.addEdge(82, 101, TransportationType.TAXI);
        this.addEdge(82, 100, TransportationType.BUS);
        this.addEdge(82, 140, TransportationType.BUS);

        // Edges of node "83"
        this.addEdge(83, 101, TransportationType.TAXI);
        this.addEdge(83, 102, TransportationType.TAXI);

        // Edges of node "84"
        this.addEdge(84, 85, TransportationType.TAXI);

        // Edges of node "85"
        this.addEdge(85, 103, TransportationType.TAXI);

        // Edges of node "86"
        this.addEdge(86, 103, TransportationType.TAXI);
        this.addEdge(86, 104, TransportationType.TAXI);
        this.addEdge(86, 87, TransportationType.BUS);
        this.addEdge(86, 102, TransportationType.BUS);
        this.addEdge(86, 116, TransportationType.BUS);

        // Edges of node "87"
        this.addEdge(87, 88, TransportationType.TAXI);
        this.addEdge(87, 105, TransportationType.BUS);

        // Edges of node "88"
        this.addEdge(88, 89, TransportationType.TAXI);
        this.addEdge(88, 117, TransportationType.TAXI);

        // Edges of node "89"
        this.addEdge(89, 105, TransportationType.TAXI);
        this.addEdge(89, 105, TransportationType.BUS);
        this.addEdge(89, 128, TransportationType.SUBWAY);

        // Edges of node "90"
        this.addEdge(90, 91, TransportationType.TAXI);
        this.addEdge(90, 105, TransportationType.TAXI);

        // Edges of node "91"
        this.addEdge(91, 105, TransportationType.TAXI);
        this.addEdge(91, 107, TransportationType.TAXI);

        // Edges of node "92"
        this.addEdge(92, 93, TransportationType.TAXI);

        // Edges of node "93"
        this.addEdge(93, 94, TransportationType.TAXI);
        this.addEdge(93, 94, TransportationType.BUS);

        // Edges of node "94"
        this.addEdge(94, 95, TransportationType.TAXI);

        // Edges of node "95"
        this.addEdge(95, 122, TransportationType.TAXI);

        // Edges of node "96"
        this.addEdge(96, 97, TransportationType.TAXI);
        this.addEdge(96, 109, TransportationType.TAXI);

        // Edges of node "97"
        this.addEdge(97, 98, TransportationType.TAXI);
        this.addEdge(97, 109, TransportationType.TAXI);

        // Edges of node "98"
        this.addEdge(98, 99, TransportationType.TAXI);
        this.addEdge(98, 110, TransportationType.TAXI);

        // Edges of node "99"
        this.addEdge(99, 110, TransportationType.TAXI);
        this.addEdge(99, 112, TransportationType.TAXI);

        // Edges of node "100"
        this.addEdge(100, 101, TransportationType.TAXI);
        this.addEdge(100, 112, TransportationType.TAXI);
        this.addEdge(100, 113, TransportationType.TAXI);
        this.addEdge(100, 111, TransportationType.BUS);

        // Edges of node "101"
        this.addEdge(101, 114, TransportationType.TAXI);

        // Edges f node "102"
        this.addEdge(102, 103, TransportationType.TAXI);
        this.addEdge(102, 115, TransportationType.TAXI);

        // Edges of node "103"
        // -> All edges already added to graph

        // Edges of node "104"
        this.addEdge(104, 116, TransportationType.TAXI);

        // Edges of node "105"
        this.addEdge(105, 106, TransportationType.TAXI);
        this.addEdge(105, 108, TransportationType.TAXI);
        this.addEdge(105, 107, TransportationType.BUS);
        this.addEdge(105, 108, TransportationType.BUS);

        // Edges of node "106"
        this.addEdge(106, 107, TransportationType.TAXI);

        // Edges of node "107"
        this.addEdge(107, 119, TransportationType.TAXI);
        this.addEdge(107, 161, TransportationType.BUS);

        // Edges of node "108"
        this.addEdge(108, 117, TransportationType.TAXI);
        this.addEdge(108, 119, TransportationType.TAXI);
        this.addEdge(108, 116, TransportationType.BUS);
        this.addEdge(108, 135, TransportationType.BUS);

        // Edges of node "109"
        this.addEdge(109, 110, TransportationType.TAXI);
        this.addEdge(109, 124, TransportationType.TAXI);

        // Edges of node "110"
        this.addEdge(110, 110, TransportationType.TAXI);

        // Edges of node "111"
        this.addEdge(111, 112, TransportationType.TAXI);
        this.addEdge(111, 124, TransportationType.TAXI);
        this.addEdge(111, 124, TransportationType.BUS);
        this.addEdge(111, 153, TransportationType.SUBWAY);
        this.addEdge(111, 163, TransportationType.SUBWAY);

        // Edges of node "112"
        this.addEdge(112, 125, TransportationType.TAXI);

        // Edges of node "113"
        this.addEdge(113, 114, TransportationType.TAXI);
        this.addEdge(113, 125, TransportationType.TAXI);

        // Edges of node "114"
        this.addEdge(114, 125, TransportationType.TAXI);
        this.addEdge(114, 126, TransportationType.TAXI);
        this.addEdge(114, 131, TransportationType.TAXI);
        this.addEdge(114, 132, TransportationType.TAXI);

        // Edges of node "115"
        this.addEdge(115, 126, TransportationType.TAXI);
        this.addEdge(115, 127, TransportationType.TAXI);

        // Edges of node "116"
        this.addEdge(116, 117, TransportationType.TAXI);
        this.addEdge(116, 118, TransportationType.TAXI);
        this.addEdge(116, 127, TransportationType.TAXI);
        this.addEdge(116, 127, TransportationType.BUS);
        this.addEdge(116, 142, TransportationType.BUS);

        // Edges of node "117"
        this.addEdge(117, 129, TransportationType.TAXI);

        // Edges of node "118"
        this.addEdge(118, 129, TransportationType.TAXI);
        this.addEdge(118, 134, TransportationType.TAXI);
        this.addEdge(118, 142, TransportationType.TAXI);

        // Edges of node "119"
        this.addEdge(119, 136, TransportationType.TAXI);

        // Edges of node "120"
        this.addEdge(120, 121, TransportationType.TAXI);
        this.addEdge(120, 144, TransportationType.TAXI);

        // Edges of node "121"
        this.addEdge(121, 122, TransportationType.TAXI);
        this.addEdge(121, 145, TransportationType.TAXI);

        // Edges of node "122"
        this.addEdge(122, 123, TransportationType.TAXI);
        this.addEdge(122, 146, TransportationType.TAXI);
        this.addEdge(122, 123, TransportationType.BUS);
        this.addEdge(122, 144, TransportationType.BUS);

        // Edges of node "123"
        this.addEdge(123, 124, TransportationType.TAXI);
        this.addEdge(123, 137, TransportationType.TAXI);
        this.addEdge(123, 148, TransportationType.TAXI);
        this.addEdge(123, 149, TransportationType.TAXI);
        this.addEdge(123, 124, TransportationType.BUS);
        this.addEdge(123, 144, TransportationType.BUS);
        this.addEdge(123, 165, TransportationType.BUS);

        // Edges of node "124"
        this.addEdge(124, 138, TransportationType.TAXI);
        this.addEdge(124, 153, TransportationType.BUS);

        // Edges of node "125"
        this.addEdge(125, 131, TransportationType.TAXI);

        // Edges of node "126"
        this.addEdge(126, 127, TransportationType.TAXI);
        this.addEdge(126, 140, TransportationType.TAXI);

        // Edges of node "127"
        this.addEdge(127, 133, TransportationType.TAXI);
        this.addEdge(127, 134, TransportationType.TAXI);
        this.addEdge(127, 133, TransportationType.BUS);

        // Edges of node "128"
        this.addEdge(128, 142, TransportationType.TAXI);
        this.addEdge(128, 143, TransportationType.TAXI);
        this.addEdge(128, 160, TransportationType.TAXI);
        this.addEdge(128, 172, TransportationType.TAXI);
        this.addEdge(128, 188, TransportationType.TAXI);
        this.addEdge(128, 135, TransportationType.BUS);
        this.addEdge(128, 142, TransportationType.BUS);
        this.addEdge(128, 161, TransportationType.BUS);
        this.addEdge(128, 187, TransportationType.BUS);
        this.addEdge(128, 199, TransportationType.BUS);
        this.addEdge(128, 140, TransportationType.SUBWAY);
        this.addEdge(128, 185, TransportationType.SUBWAY);

        // Edges of node "129"
        this.addEdge(129, 135, TransportationType.TAXI);
        this.addEdge(129, 142, TransportationType.TAXI);
        this.addEdge(129, 143, TransportationType.TAXI);

        // Edges of node "130"
        this.addEdge(130, 131, TransportationType.TAXI);
        this.addEdge(130, 139, TransportationType.TAXI);

        // Edges of node "131"
        // -> All edges already added to graph

        // Edges of node "132"
        this.addEdge(130, 140, TransportationType.TAXI);
        // Check why this edges is a duplicate

        // Edges of node "133"
        this.addEdge(130, 140, TransportationType.TAXI);
        this.addEdge(130, 141, TransportationType.TAXI);
        this.addEdge(130, 140, TransportationType.BUS);
        this.addEdge(130, 157, TransportationType.BUS);

        // Edges of node "134"
        this.addEdge(134, 141, TransportationType.TAXI);
        this.addEdge(134, 142, TransportationType.TAXI);

        // Edges of node "135"
        this.addEdge(135, 136, TransportationType.TAXI);
        this.addEdge(135, 143, TransportationType.TAXI);
        this.addEdge(135, 161, TransportationType.TAXI);
        this.addEdge(135, 161, TransportationType.BUS);

        // Edges of node "136"
        this.addEdge(136, 162, TransportationType.TAXI);

        // Edges of node "137"
        this.addEdge(137, 147, TransportationType.TAXI);

        // Edges of node "138"
        this.addEdge(138, 150, TransportationType.TAXI);
        this.addEdge(138, 152, TransportationType.TAXI);

        // Edges of node "139"
        this.addEdge(139, 140, TransportationType.TAXI);
        this.addEdge(139, 153, TransportationType.TAXI);
        this.addEdge(139, 154, TransportationType.TAXI);

        // Edges of node "140"
        this.addEdge(140, 154, TransportationType.TAXI);
        this.addEdge(140, 156, TransportationType.TAXI);
        this.addEdge(140, 154, TransportationType.BUS);
        this.addEdge(140, 156, TransportationType.BUS);
        this.addEdge(140, 153, TransportationType.SUBWAY);

        // Edges of node "141"
        this.addEdge(141, 142, TransportationType.TAXI);
        this.addEdge(141, 158, TransportationType.TAXI);

        // Edges of node "142"
        this.addEdge(142, 143, TransportationType.TAXI);
        this.addEdge(142, 158, TransportationType.TAXI);

        // Edges of node "143"
        this.addEdge(143, 160, TransportationType.TAXI);

        // Edges of node "144"
        this.addEdge(144, 145, TransportationType.TAXI);
        this.addEdge(144, 177, TransportationType.TAXI);
        this.addEdge(144, 163, TransportationType.BUS);

        // Edges of node "145"
        this.addEdge(145, 146, TransportationType.TAXI);

        // Edges of node "146"
        this.addEdge(146, 147, TransportationType.TAXI);
        this.addEdge(146, 163, TransportationType.TAXI);

        // Edges of node "147"
        this.addEdge(147, 164, TransportationType.TAXI);

        // Edges of node "148"
        this.addEdge(148, 149, TransportationType.TAXI);
        this.addEdge(148, 164, TransportationType.TAXI);

        // Edges of node "149"
        this.addEdge(149, 150, TransportationType.TAXI);
        this.addEdge(149, 165, TransportationType.TAXI);

        // Edges of node "150"
        this.addEdge(150, 151, TransportationType.TAXI);

        // Edges of node "151"
        this.addEdge(151, 152, TransportationType.TAXI);
        this.addEdge(151, 165, TransportationType.TAXI);
        this.addEdge(151, 166, TransportationType.TAXI);

        // Edges of node "152"
        this.addEdge(152, 153, TransportationType.TAXI);

        // Edges of node "153"
        this.addEdge(153, 154, TransportationType.TAXI);
        this.addEdge(153, 166, TransportationType.TAXI);
        this.addEdge(153, 167, TransportationType.TAXI);
        this.addEdge(153, 154, TransportationType.BUS);
        this.addEdge(153, 180, TransportationType.BUS);
        this.addEdge(153, 184, TransportationType.BUS);
        this.addEdge(153, 163, TransportationType.SUBWAY);
        this.addEdge(153, 185, TransportationType.SUBWAY);

        // Edges of node "154"
        this.addEdge(154, 155, TransportationType.TAXI);
        this.addEdge(154, 156, TransportationType.BUS);

        // Edges of node "155"
        this.addEdge(155, 156, TransportationType.TAXI);
        this.addEdge(155, 167, TransportationType.TAXI);
        this.addEdge(155, 168, TransportationType.TAXI);

        // Edges of node "156"
        this.addEdge(156, 157, TransportationType.TAXI);
        this.addEdge(156, 169, TransportationType.TAXI);
        this.addEdge(156, 157, TransportationType.BUS);
        this.addEdge(156, 184, TransportationType.BUS);

        // Edges of node "157"
        this.addEdge(157, 158, TransportationType.TAXI);
        this.addEdge(157, 170, TransportationType.TAXI);
        this.addEdge(157, 185, TransportationType.BUS);

        // Edges of node "158"
        this.addEdge(158, 159, TransportationType.TAXI);

        // Edges of node "159"
        this.addEdge(159, 170, TransportationType.TAXI);
        this.addEdge(159, 172, TransportationType.TAXI);
        this.addEdge(159, 186, TransportationType.TAXI);
        this.addEdge(159, 198, TransportationType.TAXI);

        // Edges of node "160"
        this.addEdge(160, 161, TransportationType.TAXI);
        this.addEdge(160, 173, TransportationType.TAXI);

        // Edges of node "161"
        this.addEdge(161, 174, TransportationType.TAXI);
        this.addEdge(161, 199, TransportationType.BUS);

        // Edges of node "162"
        this.addEdge(162, 175, TransportationType.TAXI);

        // Edges of node "163"
        this.addEdge(163, 177, TransportationType.TAXI);
        this.addEdge(163, 176, TransportationType.BUS);
        this.addEdge(163, 191, TransportationType.BUS);

        // Edges of node "164"
        this.addEdge(164, 178, TransportationType.TAXI);
        this.addEdge(164, 179, TransportationType.TAXI);

        // Edges of node "165"
        this.addEdge(165, 179, TransportationType.TAXI);
        this.addEdge(165, 180, TransportationType.TAXI);
        this.addEdge(165, 180, TransportationType.BUS);
        this.addEdge(165, 191, TransportationType.BUS);

        // Edges of node "166"
        this.addEdge(166, 181, TransportationType.TAXI);
        this.addEdge(166, 183, TransportationType.TAXI);

        // Edges of node "167"
        this.addEdge(167, 168, TransportationType.TAXI);
        this.addEdge(167, 183, TransportationType.TAXI);

        // Edges of node "168"
        this.addEdge(168, 184, TransportationType.TAXI);

        // Edges of node "169"
        this.addEdge(169, 184, TransportationType.TAXI);

        // Edges of node "170"
        this.addEdge(170, 185, TransportationType.TAXI);

        // Edges of node "171"
        this.addEdge(171, 173, TransportationType.TAXI);
        this.addEdge(171, 175, TransportationType.TAXI);
        this.addEdge(171, 199, TransportationType.TAXI);

        // Edges of node "172"
        this.addEdge(172, 187, TransportationType.TAXI);

        // Edges of node "173"
        this.addEdge(173, 174, TransportationType.TAXI);
        this.addEdge(173, 188, TransportationType.TAXI);

        // Edges of node "174"
        this.addEdge(174, 175, TransportationType.TAXI);

        // Edges of node "175"
        // -> All edges already added to graph

        // Edges of node "176"
        this.addEdge(176, 177, TransportationType.TAXI);
        this.addEdge(176, 189, TransportationType.TAXI);
        this.addEdge(176, 189, TransportationType.BUS);

        // Edges of node "177"
        // -> All edges already added to graph

        // Edges of node "178"
        this.addEdge(177, 189, TransportationType.TAXI);
        this.addEdge(177, 191, TransportationType.TAXI);

        // Edges of node "179"
        this.addEdge(179, 191, TransportationType.TAXI);

        // Edges of node "180"
        this.addEdge(180, 181, TransportationType.TAXI);
        this.addEdge(180, 193, TransportationType.TAXI);
        this.addEdge(180, 184, TransportationType.BUS);
        this.addEdge(180, 190, TransportationType.BUS);

        // Edges of node "181"
        this.addEdge(181, 182, TransportationType.TAXI);
        this.addEdge(181, 193, TransportationType.TAXI);

        // Edges of node "182"
        this.addEdge(182, 183, TransportationType.TAXI);
        this.addEdge(182, 195, TransportationType.TAXI);

        // Edges of node "183"
        this.addEdge(183, 196, TransportationType.TAXI);

        // Edges of node "184"
        this.addEdge(184, 185, TransportationType.TAXI);
        this.addEdge(184, 196, TransportationType.TAXI);
        this.addEdge(184, 197, TransportationType.TAXI);
        this.addEdge(184, 185, TransportationType.BUS);

        // Edges of node "185"
        this.addEdge(185, 186, TransportationType.TAXI);
        this.addEdge(185, 198, TransportationType.BUS);

        // Edges of node "186"
        this.addEdge(186, 198, TransportationType.TAXI);

        // Edges of node "187"
        this.addEdge(187, 188, TransportationType.TAXI);
        this.addEdge(187, 198, TransportationType.TAXI);

        // Edges of node "188"
        this.addEdge(188, 199, TransportationType.TAXI);

        // Edges of node "189"
        this.addEdge(189, 190, TransportationType.TAXI);

        // Edges of node "190"
        this.addEdge(190, 191, TransportationType.TAXI);
        this.addEdge(190, 192, TransportationType.TAXI);
        this.addEdge(190, 191, TransportationType.BUS);

        // Edges of node "191"
        this.addEdge(191, 192, TransportationType.TAXI);

        // Edges of node "192"
        this.addEdge(192, 194, TransportationType.TAXI);

        // Edges of node "193"
        this.addEdge(193, 194, TransportationType.TAXI);

        // Edges of node "194"
        this.addEdge(194, 195, TransportationType.TAXI);

        // Edges of node "195"
        this.addEdge(195, 197, TransportationType.TAXI);

        // Edges of node "196"
        this.addEdge(196, 197, TransportationType.TAXI);

        // Edges of node "197"
        // -> All edges already added to graph

        // Edges of node "198"
        this.addEdge(198, 199, TransportationType.TAXI);

        // Edges of node "199"
        // -> All edges already added to graph
    }

    private void addEdge(int firstNode, int secondNode, TransportationType type) throws  InvalidNode {
        this.graph.addEdge(this.graph.findNode(firstNode), this.graph.findNode(secondNode), type);
    }
}
