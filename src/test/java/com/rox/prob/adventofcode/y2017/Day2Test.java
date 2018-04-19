package com.rox.prob.adventofcode.y2017;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Ross W. Drew
 */
public class Day2Test {
    @Test
    public void testPart1Example(){
        int[][] speadsheet = new int[][] {{5,1,9,5},
                                          {7,5,3},
                                          {2,4,6,8}};
        assertEquals(18, Day2.part1Solution(speadsheet));
    }

    @Test
    public void testPart1SimpleSolution(){
        int[][] spreadsheet = new int[][] {  {116,1470,2610,179,2161,2690,831,1824,2361,1050,2201,118,145,2275,2625,2333},
                                             {976,220,1129,553,422,950,332,204,1247,1092,1091,159,174,182,984,713},
                                             {84,78,773,62,808,83,1125,1110,1184,145,1277,982,338,1182,75,679},
                                             {3413,3809,3525,2176,141,1045,2342,2183,157,3960,3084,2643,119,108,3366,2131},
                                             {1312,205,343,616,300,1098,870,1008,1140,1178,90,146,980,202,190,774},
                                             {4368,3905,3175,4532,3806,1579,4080,259,2542,221,4395,4464,208,3734,234,4225},
                                             {741,993,1184,285,1062,372,111,118,63,843,325,132,854,105,956,961},
                                             {85,79,84,2483,858,2209,2268,90,2233,1230,2533,322,338,68,2085,1267},
                                             {2688,2022,112,130,1185,103,1847,3059,911,107,2066,1788,2687,2633,415,1353},
                                             {76,169,141,58,161,66,65,225,60,152,62,64,156,199,80,56},
                                             {220,884,1890,597,3312,593,4259,222,113,2244,3798,4757,216,1127,4400,178},
                                             {653,369,216,132,276,102,265,889,987,236,239,807,1076,932,84,864},
                                             {799,739,75,1537,82,228,69,1397,1396,1203,1587,63,313,1718,1375,469},
                                             {1176,112,1407,136,1482,1534,1384,1202,604,851,190,284,1226,113,114,687},
                                             {73,1620,81,1137,812,75,1326,1355,1545,1666,1356,1681,1732,85,128,902},
                                             {571,547,160,237,256,30,496,592,385,576,183,692,192,387,647,233}
                                          };

        assertEquals(32020, Day2.part1Solution(spreadsheet));

    }

    @Test
    public void testPart1Solution(){
        String questionAsString = "116	1470	2610	179	2161	2690	831	1824	2361	1050	2201	118	145	2275	2625	2333\n" +
                                  "976	220	1129	553	422	950	332	204	1247	1092	1091	159	174	182	984	713\n" +
                                  "84	78	773	62	808	83	1125	1110	1184	145	1277	982	338	1182	75	679\n" +
                                  "3413	3809	3525	2176	141	1045	2342	2183	157	3960	3084	2643	119	108	3366	2131\n" +
                                  "1312	205	343	616	300	1098	870	1008	1140	1178	90	146	980	202	190	774\n" +
                                  "4368	3905	3175	4532	3806	1579	4080	259	2542	221	4395	4464	208	3734	234	4225\n" +
                                  "741	993	1184	285	1062	372	111	118	63	843	325	132	854	105	956	961\n" +
                                  "85	79	84	2483	858	2209	2268	90	2233	1230	2533	322	338	68	2085	1267\n" +
                                  "2688	2022	112	130	1185	103	1847	3059	911	107	2066	1788	2687	2633	415	1353\n" +
                                  "76	169	141	58	161	66	65	225	60	152	62	64	156	199	80	56\n" +
                                  "220	884	1890	597	3312	593	4259	222	113	2244	3798	4757	216	1127	4400	178\n" +
                                  "653	369	216	132	276	102	265	889	987	236	239	807	1076	932	84	864\n" +
                                  "799	739	75	1537	82	228	69	1397	1396	1203	1587	63	313	1718	1375	469\n" +
                                  "1176	112	1407	136	1482	1534	1384	1202	604	851	190	284	1226	113	114	687\n" +
                                  "73	1620	81	1137	812	75	1326	1355	1545	1666	1356	1681	1732	85	128	902\n" +
                                  "571	547	160	237	256	30	496	592	385	576	183	692	192	387	647	233\n";

        assertEquals(32020, Day2.part1Solution(questionAsString));
    }

    @Test
    public void testPart2Example(){
        int[][] speadsheet = new int[][] {{5,9,2,8},
                                          {9,4,7,3},
                                          {3,8,6,5}};

        assertEquals(9, Day2.part2Solution(speadsheet));
    }

    @Test
    public void testPart2Solution(){
        String questionAsString =   "116\t1470\t2610\t179\t2161\t2690\t831\t1824\t2361\t1050\t2201\t118\t145\t2275\t2625\t2333\n" +
                                    "976\t220\t1129\t553\t422\t950\t332\t204\t1247\t1092\t1091\t159\t174\t182\t984\t713\n" +
                                    "84\t78\t773\t62\t808\t83\t1125\t1110\t1184\t145\t1277\t982\t338\t1182\t75\t679\n" +
                                    "3413\t3809\t3525\t2176\t141\t1045\t2342\t2183\t157\t3960\t3084\t2643\t119\t108\t3366\t2131\n" +
                                    "1312\t205\t343\t616\t300\t1098\t870\t1008\t1140\t1178\t90\t146\t980\t202\t190\t774\n" +
                                    "4368\t3905\t3175\t4532\t3806\t1579\t4080\t259\t2542\t221\t4395\t4464\t208\t3734\t234\t4225\n" +
                                    "741\t993\t1184\t285\t1062\t372\t111\t118\t63\t843\t325\t132\t854\t105\t956\t961\n" +
                                    "85\t79\t84\t2483\t858\t2209\t2268\t90\t2233\t1230\t2533\t322\t338\t68\t2085\t1267\n" +
                                    "2688\t2022\t112\t130\t1185\t103\t1847\t3059\t911\t107\t2066\t1788\t2687\t2633\t415\t1353\n" +
                                    "76\t169\t141\t58\t161\t66\t65\t225\t60\t152\t62\t64\t156\t199\t80\t56\n" +
                                    "220\t884\t1890\t597\t3312\t593\t4259\t222\t113\t2244\t3798\t4757\t216\t1127\t4400\t178\n" +
                                    "653\t369\t216\t132\t276\t102\t265\t889\t987\t236\t239\t807\t1076\t932\t84\t864\n" +
                                    "799\t739\t75\t1537\t82\t228\t69\t1397\t1396\t1203\t1587\t63\t313\t1718\t1375\t469\n" +
                                    "1176\t112\t1407\t136\t1482\t1534\t1384\t1202\t604\t851\t190\t284\t1226\t113\t114\t687\n" +
                                    "73\t1620\t81\t1137\t812\t75\t1326\t1355\t1545\t1666\t1356\t1681\t1732\t85\t128\t902\n" +
                                    "571\t547\t160\t237\t256\t30\t496\t592\t385\t576\t183\t692\t192\t387\t647\t233";

        assertEquals(236, Day2.part2Solution(questionAsString));
    }
}