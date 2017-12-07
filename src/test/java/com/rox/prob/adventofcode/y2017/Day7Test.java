package com.rox.prob.adventofcode.y2017;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Day7Test {
    private static final String EXAMPLE_INPUT = "pbga (66)\n"+
                                                "xhth (57)\n"+
                                                "ebii (61)\n"+
                                                "havc (66)\n"+
                                                "ktlj (57)\n"+
                                                "fwft (72) -> ktlj, cntj, xhth\n"+
                                                "qoyq (66)\n"+
                                                "padx (45) -> pbga, havc, qoyq\n"+
                                                "tknk (41) -> ugml, padx, fwft\n"+
                                                "jptl (61)\n"+
                                                "ugml (68) -> gyxo, ebii, jptl\n"+
                                                "gyxo (61)\n"+
                                                "cntj (57)";

    private static final String PROBLEM_INPUT = "keztg (7)\n" +
                                                "uwbtawx (9)\n" +
                                                "mgyhaax (46)\n" +
                                                "fuvokrr (14) -> pnjbsm, glrua\n" +
                                                "cymmj (257) -> phyzvno, pmfprs, ozgprze, bgjngh\n" +
                                                "goilxo (80)\n" +
                                                "cumfrfc (102) -> yjivxcf, swqkqgz\n" +
                                                "yquljjj (20)\n" +
                                                "ehywag (18)\n" +
                                                "mmtyhkd (21)\n" +
                                                "paglk (98)\n" +
                                                "wtqfs (82)\n" +
                                                "oaynkf (8)\n" +
                                                "cupbfut (78)\n" +
                                                "vpcruoy (70)\n" +
                                                "wmdbo (50)\n" +
                                                "tmbtipi (48)\n" +
                                                "lkopm (9)\n" +
                                                "gluzk (18)\n" +
                                                "prvrg (76)\n" +
                                                "lkdkyk (30) -> oldwss, nadxwf\n" +
                                                "iqsztjd (181) -> hovelvz, pndcqot, naglm, oxxlsk\n" +
                                                "nxdkpuh (217) -> yhcsc, ydmeqtl\n" +
                                                "nxlhjq (306) -> hcwjxe, zixbap\n" +
                                                "vtkgj (89)\n" +
                                                "rzrzage (73)\n" +
                                                "ftegwk (284)\n" +
                                                "lircjh (23)\n" +
                                                "zosskdz (232) -> isrch, bwzvefg, dxodoee\n" +
                                                "dphcbfr (67)\n" +
                                                "pnmvk (180) -> wrabgy, vlfpuo\n" +
                                                "owmjbhg (120) -> szfxhin, czzpk, zwrfiyf\n" +
                                                "oonqts (26)\n" +
                                                "zjaqq (129) -> hopjmyt, cdwkezv\n" +
                                                "hxeoxk (33)\n" +
                                                "csaqixs (1237) -> alzipi, lhxycw, tkeuvp\n" +
                                                "avenz (7)\n" +
                                                "nnhknbl (55) -> owzwbpn, iaonkp\n" +
                                                "bxifcld (86)\n" +
                                                "neyeo (165) -> gxxzwq, fxwez\n" +
                                                "qnjpz (71)\n" +
                                                "qhxmh (61)\n" +
                                                "jmhfgr (139) -> ucuqxgm, hovhxsp\n" +
                                                "tyuhzom (80)\n" +
                                                "pqtboz (207) -> ayvns, codwosk\n" +
                                                "dqyjg (65)\n" +
                                                "nujppls (24)\n" +
                                                "mxbixyi (60)\n" +
                                                "xkzgz (85)\n" +
                                                "oxklzu (2285) -> ehwlw, fptoo, sgobq, eduwet, pqmpnzo\n" +
                                                "fuleuxt (6) -> ljzuyyk, pxydes\n" +
                                                "zktmxll (451) -> txsrez, ewjrko, drtrgwp, kiggy\n" +
                                                "qpxbow (40)\n" +
                                                "rshpnha (36)\n" +
                                                "pqmpnzo (1374) -> hpltoci, oxvwr, vrxeemw\n" +
                                                "wdazzdu (54)\n" +
                                                "kivcyus (53)\n" +
                                                "cvvncju (10)\n" +
                                                "dtkuik (36)\n" +
                                                "opkvs (64)\n" +
                                                "kwjnfg (28)\n" +
                                                "suoiohi (197) -> gluzk, fdhdpw\n" +
                                                "jkaxk (98)\n" +
                                                "zsoro (12)\n" +
                                                "fqvtm (15)\n" +
                                                "nqktjw (14)\n" +
                                                "cbhkkx (116) -> wrprrev, vyoxx\n" +
                                                "rmqdolg (55)\n" +
                                                "mdkes (95)\n" +
                                                "obxansb (343) -> uzyprc, uxaqq\n" +
                                                "pjitmnv (31)\n" +
                                                "vdkrvi (73)\n" +
                                                "nystxqv (35)\n" +
                                                "odgzsnk (73)\n" +
                                                "hehbbo (83)\n" +
                                                "zrthre (30)\n" +
                                                "zwoot (9)\n" +
                                                "mfawmsq (92)\n" +
                                                "sckaqs (1141) -> qpaei, cbhkkx, qezwkkx\n" +
                                                "vxfci (60) -> tdecuga, wssvxr, pchccgz, ypogtw\n" +
                                                "vauwilt (78)\n" +
                                                "qxkas (24) -> mzgyj, xappjar, cgbgm, muarkn\n" +
                                                "eqibqs (20)\n" +
                                                "wuefg (549) -> pwwyeqx, ylidl, qwbfod, mqztoa\n" +
                                                "jmchsu (77)\n" +
                                                "dinng (30)\n" +
                                                "nlpmbrd (37) -> fnzjtvw, qzjyi\n" +
                                                "yjivxcf (19)\n" +
                                                "yhjopn (34)\n" +
                                                "hqxdyv (17568) -> apktiv, ybekxtf, etoxfc\n" +
                                                "wvivxrz (82)\n" +
                                                "wszqat (85) -> eddmyv, edkwqih, mxbixyi\n" +
                                                "xcldsl (78)\n" +
                                                "rnbzlx (35)\n" +
                                                "hibxz (94) -> zgzsu, vzgsgk\n" +
                                                "rgyco (21)\n" +
                                                "lmvvs (22)\n" +
                                                "nezny (13)\n" +
                                                "tpcvq (251)\n" +
                                                "puxgb (15)\n" +
                                                "merrako (8)\n" +
                                                "nzweur (431) -> rfouw, sukktk, rreqg, fmpcnql\n" +
                                                "pwwyeqx (100) -> fmjhlia, yquljjj\n" +
                                                "lccoo (27) -> bmlid, prvrg\n" +
                                                "dudxud (202)\n" +
                                                "cmnzh (49)\n" +
                                                "nitvw (8)\n" +
                                                "dcakuo (21)\n" +
                                                "nnbty (81)\n" +
                                                "kjlxeat (318) -> nmhww, zacsvwk\n" +
                                                "frinpfj (88) -> lwfoqny, tdgel\n" +
                                                "zgqsgm (38) -> phdcpp, qwcrc\n" +
                                                "bvikij (91) -> obxansb, bizbsjd, usggwvu, zrhny, svngfr\n" +
                                                "dnycw (219) -> sibzrx, hdgvs, wnfqg\n" +
                                                "youpfn (38)\n" +
                                                "zixbap (47)\n" +
                                                "mpwldri (55)\n" +
                                                "rfqenw (80)\n" +
                                                "tjtzx (78)\n" +
                                                "zbfut (55)\n" +
                                                "eruxzoi (63)\n" +
                                                "nandmg (344) -> qpqplm, zrthre\n" +
                                                "bizbsjd (159) -> piecd, ghkdvw, caurb\n" +
                                                "jpkwter (19) -> mcjgfx, ujsbt\n" +
                                                "uwpbnv (83)\n" +
                                                "devljb (45)\n" +
                                                "euzztul (30)\n" +
                                                "frmbrb (1660) -> norkse, iitweo, mebwy, sckaqs, xdrge\n" +
                                                "duccgc (15)\n" +
                                                "bmlid (76)\n" +
                                                "clwwv (238) -> jofvyvx, zgjoaiw\n" +
                                                "llmmm (69) -> wvivxrz, pikvdx\n" +
                                                "rstdh (21)\n" +
                                                "afckjn (51)\n" +
                                                "ojqia (22)\n" +
                                                "qtlzten (155) -> fjgsw, uujpt\n" +
                                                "eqxgwfz (40)\n" +
                                                "ljwsi (20)\n" +
                                                "vuxbzm (48)\n" +
                                                "qzuwt (130) -> qnrjqj, bjdtdn\n" +
                                                "lnnwiq (20)\n" +
                                                "pbxpdo (281) -> vabmsx, kwjnfg\n" +
                                                "bfcdy (31)\n" +
                                                "ykpsfj (28)\n" +
                                                "uegcs (210)\n" +
                                                "qezwkkx (74) -> gquil, stfzaxc\n" +
                                                "jkvduo (44)\n" +
                                                "vtylgti (66) -> twgbxu, uukshmq, rlvggmr, aynpr\n" +
                                                "eyyokyd (28)\n" +
                                                "nrbcaqo (45)\n" +
                                                "caocs (35)\n" +
                                                "cfdpxpm (207) -> jhwmc, nezny\n" +
                                                "qwjmobb (28425) -> ohusizx, gqoxv, xatjlb\n" +
                                                "akniuo (129) -> zpczji, tugrmnp\n" +
                                                "kravhjd (17)\n" +
                                                "wtbwbpz (43) -> kybegv, qxhda\n" +
                                                "hovelvz (31)\n" +
                                                "jhwmc (13)\n" +
                                                "wctze (102) -> qwdhdrk, znooxvq, vhrxl, zfhkfwn\n" +
                                                "nmhww (43)\n" +
                                                "fqufwq (58)\n" +
                                                "zyxjg (81)\n" +
                                                "eltbyz (61)\n" +
                                                "ehtsbv (783) -> upaqlj, cckqr, pgprg, ubksf\n" +
                                                "zbrbb (12)\n" +
                                                "vjgvk (28)\n" +
                                                "mqulwk (15)\n" +
                                                "kywmnbd (404)\n" +
                                                "wcuvk (20)\n" +
                                                "ymfls (75)\n" +
                                                "spxwcuv (173) -> iobcvl, xwfbb, wxpauwt\n" +
                                                "eumzi (24)\n" +
                                                "kqoigs (53) -> krfgye, oxklzu, pinipk, ojatf, memkrd\n" +
                                                "alneqju (77)\n" +
                                                "joczsir (313) -> xwkoc, atkmjxg, gurxxfd, axxkh, jmpknjs\n" +
                                                "uwzvy (35)\n" +
                                                "xqxyx (386) -> avenz, keztg\n" +
                                                "erylwj (804) -> wdsbi, ugrhs, fzmaw\n" +
                                                "corfkob (87)\n" +
                                                "sibzrx (67) -> pqccp, audeogd\n" +
                                                "crrfxfn (38)\n" +
                                                "piecd (72)\n" +
                                                "bxefs (22)\n" +
                                                "lnufi (93)\n" +
                                                "qifuph (44)\n" +
                                                "uqccsbh (26)\n" +
                                                "jaqwzi (79) -> zkgoa, juymjz\n" +
                                                "nivpffu (169) -> tnccv, lfqca, sgfco, nnbbrbf, egsgwch\n" +
                                                "dfrkf (49)\n" +
                                                "cdrhm (56)\n" +
                                                "vaylgz (80)\n" +
                                                "ayvns (23)\n" +
                                                "mdddafe (56)\n" +
                                                "fpldxlq (195) -> gjnnmvb, ljwsi\n" +
                                                "eygaz (427) -> ascyv, kmjfxcf, puxgb\n" +
                                                "ymeelep (92)\n" +
                                                "iuzvl (23)\n" +
                                                "tkjeu (41)\n" +
                                                "xdlyd (75) -> cymmj, pbxpdo, vmjbgo, cwttq\n" +
                                                "jsltf (39)\n" +
                                                "ciojx (146) -> ioobamp, ahrfot\n" +
                                                "eqmeu (211) -> anrjxof, nepxnu, mwpbyo, rbzqabo\n" +
                                                "bogvr (202) -> zghrr, bompiu\n" +
                                                "jefztzv (91)\n" +
                                                "fvikm (80) -> zepvwyv, oonqts\n" +
                                                "zdqcu (194) -> ucbuez, nqktjw\n" +
                                                "pdvolf (75)\n" +
                                                "mkmci (40) -> ggaxx, xvzlrw\n" +
                                                "sqmfis (35)\n" +
                                                "chrqi (74)\n" +
                                                "tvgytpm (49)\n" +
                                                "bjoyw (29)\n" +
                                                "nkfvkp (62)\n" +
                                                "xbtswv (7446) -> iehfo, xcrkb, qksclw\n" +
                                                "qomxhp (721) -> agufw, djgzb, jxbksoh, twnfzz, ucxgom\n" +
                                                "ibmiu (9)\n" +
                                                "atmzoso (6) -> drosj, wcrrrlf\n" +
                                                "fuqvw (56)\n" +
                                                "jfaca (49)\n" +
                                                "yulga (213)\n" +
                                                "dxodoee (7)\n" +
                                                "gethyvd (39)\n" +
                                                "hjxcpi (30)\n" +
                                                "jlcgqt (55)\n" +
                                                "lzouo (144) -> ubjgijo, rnbzlx\n" +
                                                "djyxrkb (78)\n" +
                                                "bscpyic (61) -> nktmu, sqpdsk\n" +
                                                "sxmdnhl (31)\n" +
                                                "qbdafi (25)\n" +
                                                "vwbxg (35)\n" +
                                                "rlvggmr (63)\n" +
                                                "kiggy (27) -> pgsokae, ottiad, eruxzoi, zhttn\n" +
                                                "ocpngbz (73) -> hqzay, ewzryd, ipjbc, xjnhqlg\n" +
                                                "movmxq (216) -> kfxhl, ulpkj\n" +
                                                "mzgyj (85)\n" +
                                                "orwbdwn (52)\n" +
                                                "ixyqeq (6735) -> xgwjcx, nkkgyl, sykwd\n" +
                                                "htsjndf (211)\n" +
                                                "ndhsa (82)\n" +
                                                "jmpknjs (80) -> gdrcfwr, wgivp\n" +
                                                "hieel (65)\n" +
                                                "htdwe (25)\n" +
                                                "qrfuvjh (9)\n" +
                                                "ubjgijo (35)\n" +
                                                "vobnpuq (32)\n" +
                                                "elgyjo (141) -> ineoncq, pfdmmg\n" +
                                                "zsnge (71)\n" +
                                                "zbwxa (28)\n" +
                                                "ogczchc (31)\n" +
                                                "njdpm (53)\n" +
                                                "cpsce (84)\n" +
                                                "ftdylco (19)\n" +
                                                "zrwfi (22)\n" +
                                                "hyfuy (252) -> pmscqw, ecaph\n" +
                                                "nayudfl (320) -> ssvsso, zrwfi\n" +
                                                "kykfb (72) -> euzztul, vxrtejs\n" +
                                                "ggpjxwv (9)\n" +
                                                "aostqf (29)\n" +
                                                "zujltb (13) -> hatvlca, ppmrgga, cjoya, bogvr, gtbpbl, ocwkc, qzuwt\n" +
                                                "ajbtn (18)\n" +
                                                "fzmaw (20) -> qjixqo, fkhxkeg, uqccsbh\n" +
                                                "akmbqb (108) -> kqkzsm, grgsn\n" +
                                                "slrdn (55)\n" +
                                                "nrjwctg (96)\n" +
                                                "norkse (661) -> jmhfgr, anwxvv, ptwhbm, znubct, djrrc, hgmjvpp\n" +
                                                "bwzvefg (7)\n" +
                                                "peuadz (8)\n" +
                                                "kvmqsdx (308) -> zvtoom, twvdhg\n" +
                                                "bvnjiou (32)\n" +
                                                "lnwuqu (159) -> yeqnq, fqvtm\n" +
                                                "pksfx (54)\n" +
                                                "xatua (97)\n" +
                                                "tbrznk (37)\n" +
                                                "ucuqxgm (31)\n" +
                                                "hwjhf (78)\n" +
                                                "pinipk (7229) -> pqewl, zujltb, kfcowx\n" +
                                                "yyhzd (12) -> kvqspmf, dtkuik, wsvir\n" +
                                                "imyvlyt (38)\n" +
                                                "oldwss (96)\n" +
                                                "paegovu (86)\n" +
                                                "knjlz (83)\n" +
                                                "oevbo (23)\n" +
                                                "yeucm (98)\n" +
                                                "usvkq (56)\n" +
                                                "hatvlca (69) -> gpogy, eyrfvtl, subwna\n" +
                                                "qkhtsa (208) -> pyxgmtu, pqgpuv, pudnxf, dilqo, juqbdco, flufot, fzdyvo\n" +
                                                "gzvjxk (1397) -> wctze, zoijv, fuleuxt\n" +
                                                "bkwcwf (326) -> jazkpl, kfcgv, qpjctjw\n" +
                                                "vqghhbs (157) -> lsrvhoi, livmxo\n" +
                                                "fzdyvo (186) -> gwfrqr, tcgffi\n" +
                                                "rqkfkxw (47)\n" +
                                                "bntdh (76)\n" +
                                                "rfmiqz (158) -> omlwg, uhwvnbg\n" +
                                                "zorvsm (50)\n" +
                                                "edzgraw (83)\n" +
                                                "iwsknb (345) -> qhqnfsp, vrwkr\n" +
                                                "vyoxx (63)\n" +
                                                "livmxo (27)\n" +
                                                "foabep (92)\n" +
                                                "dbuccip (28)\n" +
                                                "oojme (73) -> ugkxkqe, keucu, zjqeu\n" +
                                                "cmmqbz (29868) -> frmbrb, ixyqeq, njatvu\n" +
                                                "syjvwzt (6039) -> bigkiu, wjipa, pmbnia\n" +
                                                "uxaqq (16)\n" +
                                                "vboha (79)\n" +
                                                "irsfgz (94)\n" +
                                                "lsrvhoi (27)\n" +
                                                "zdtvktq (99) -> ezrix, lyhfj\n" +
                                                "hgbkwjv (32)\n" +
                                                "inxivh (261) -> mzzxjcu, rkaxx\n" +
                                                "nfrtom (44)\n" +
                                                "xhzylb (97)\n" +
                                                "nuxqskl (39)\n" +
                                                "qhfxqrr (65)\n" +
                                                "foaayon (78)\n" +
                                                "rhtdtxv (234) -> rplxsw, fjqomax\n" +
                                                "kppxrk (73)\n" +
                                                "qjixqo (26)\n" +
                                                "sgngx (75)\n" +
                                                "ycsbsyn (87) -> gmeueu, wdhmsi, zrqqtx\n" +
                                                "kqkzsm (61)\n" +
                                                "irjvpam (39) -> ajozeez, xxlbk, nfwlplx\n" +
                                                "ldfofo (84)\n" +
                                                "mygcpku (84)\n" +
                                                "caurb (72)\n" +
                                                "gpysit (22)\n" +
                                                "gxfij (171) -> sxnsqj, ksxixz\n" +
                                                "mxbyg (39)\n" +
                                                "jlshk (29)\n" +
                                                "havdbe (132) -> dqyjg, wvdapsm\n" +
                                                "ocwkc (86) -> dtzws, fleszz\n" +
                                                "rqrtz (83)\n" +
                                                "eddmyv (60)\n" +
                                                "ecaph (56)\n" +
                                                "ebgsk (60) -> rshpnha, puexzf\n" +
                                                "lymsa (44) -> qcyypa, vbdcxx\n" +
                                                "mozvs (54) -> dfrkf, cmnzh\n" +
                                                "kpghxz (17)\n" +
                                                "wrpqf (83)\n" +
                                                "dzjsx (57)\n" +
                                                "vrzbmt (14)\n" +
                                                "dryngd (29) -> shawokt, elkflt, tjtzx, auiiuv\n" +
                                                "ittmm (28)\n" +
                                                "zqurr (284) -> fqufwq, htsuyvw\n" +
                                                "ktejrze (69)\n" +
                                                "pudnxf (192) -> aostqf, szwpt\n" +
                                                "tqjlm (74)\n" +
                                                "codwosk (23)\n" +
                                                "pmscqw (56)\n" +
                                                "cmcto (441)\n" +
                                                "edoycls (93) -> vvnzr, imnvt, vuxbzm, rhzco\n" +
                                                "zrhny (177) -> dcwfs, dppwsec\n" +
                                                "vffew (46)\n" +
                                                "hcwjxe (47)\n" +
                                                "dinlw (342) -> zzjuf, lnwuqu, gxfij, kmqurp\n" +
                                                "lgtpaqk (75)\n" +
                                                "fluwt (65)\n" +
                                                "syuoewb (288) -> uwbtawx, avjkgl, nkycb\n" +
                                                "anrjxof (6)\n" +
                                                "vrwkr (5)\n" +
                                                "pngubp (76)\n" +
                                                "vvnhe (89)\n" +
                                                "rnlaw (45) -> wszqat, ptizsk, mofyda, ttolm, velktz, nzsnkla, hhdzz\n" +
                                                "nadxwf (96)\n" +
                                                "sxpan (31)\n" +
                                                "gdrcfwr (71)\n" +
                                                "vabmsx (28)\n" +
                                                "tsiyp (52)\n" +
                                                "fptoo (1398) -> gintpbf, cklkizf, kjgtfqc\n" +
                                                "obxrn (756) -> yyhzd, afatio, uqjge\n" +
                                                "znkchkk (50)\n" +
                                                "hvapnf (121) -> siruccf, tgpxvyr\n" +
                                                "htsuyvw (58)\n" +
                                                "yifny (122) -> dcakuo, xhtzti\n" +
                                                "uvvqcxz (79)\n" +
                                                "suiyl (773) -> hjfwn, thknml, gkijw\n" +
                                                "shawokt (78)\n" +
                                                "ezdiq (37)\n" +
                                                "khrqmbo (9)\n" +
                                                "gkjbikb (79) -> nrjwctg, iamrpx\n" +
                                                "ysskib (76)\n" +
                                                "zufoz (93) -> smrvw, kkkjsil\n" +
                                                "uusiaqf (84)\n" +
                                                "cjxyt (69) -> deczzuu, ymeelep\n" +
                                                "gcefq (33)\n" +
                                                "tgebda (247) -> ngthpc, bnvlsm, afckjn\n" +
                                                "ljmve (55)\n" +
                                                "rqdcuf (144) -> xzxvwzf, bjoyw\n" +
                                                "sjxaxv (76)\n" +
                                                "jiybx (88)\n" +
                                                "wxpauwt (20)\n" +
                                                "clsbdm (10)\n" +
                                                "fmpcnql (56) -> rjvfwcu, xjjdapk, nwtlu\n" +
                                                "hchmn (258) -> bremy, vpcruoy\n" +
                                                "labnsw (157) -> wnwsbdq, jqjkgv\n" +
                                                "hvpcvdf (95)\n" +
                                                "xatjlb (40) -> aiunbee, keoaqjb, jxkofob, plbtdq\n" +
                                                "dflvw (86)\n" +
                                                "vmcgj (233)\n" +
                                                "jxwyzy (13)\n" +
                                                "mebwy (1107) -> uegez, dpiyhv, vdzuw, icpwoof\n" +
                                                "btqebbp (156)\n" +
                                                "mmvszxj (71)\n" +
                                                "gpysm (85)\n" +
                                                "dppwsec (99)\n" +
                                                "iodveqh (89)\n" +
                                                "xcycu (116) -> dnkiyf, njdpm\n" +
                                                "ijictm (38)\n" +
                                                "ineay (19)\n" +
                                                "hvdpzbv (73)\n" +
                                                "cckqr (148) -> rqhfhc, jcyciyq, jbqvpsb, uapwikr\n" +
                                                "opowpvm (265) -> aewie, phrume\n" +
                                                "ptwhbm (69) -> omzlzx, suxpc\n" +
                                                "bpdixmv (83)\n" +
                                                "mzlmr (43)\n" +
                                                "ezrix (79)\n" +
                                                "jovly (61)\n" +
                                                "audeogd (99)\n" +
                                                "hjfwn (168) -> wtqfs, uamje\n" +
                                                "wdhbym (184) -> pksfx, bgahvfu, krlep, pkmmfc\n" +
                                                "nmmtdv (83)\n" +
                                                "uftwml (50)\n" +
                                                "ycyyvdy (17)\n" +
                                                "dqdpop (53) -> ggllv, zatwq\n" +
                                                "egqmgr (37)\n" +
                                                "txsrez (99) -> iiznokx, dobmve\n" +
                                                "lqmdutk (25)\n" +
                                                "mfecx (33)\n" +
                                                "kldww (23)\n" +
                                                "dxbxha (135) -> uvswv, ydmrd\n" +
                                                "xmvdh (41)\n" +
                                                "ctinwus (96)\n" +
                                                "arkedwb (237) -> qsvckew, merrako\n" +
                                                "iaonkp (89)\n" +
                                                "uthjdye (124) -> awoedy, wuisqnk, qsfpaj\n" +
                                                "yzbccbx (36) -> fxemb, osryil, nkfvkp\n" +
                                                "xvlymgg (33)\n" +
                                                "wbbaxr (10)\n" +
                                                "wcrrrlf (98)\n" +
                                                "bclse (38) -> slgjon, tzltv\n" +
                                                "krzjli (33)\n" +
                                                "dnkiyf (53)\n" +
                                                "cklkizf (219)\n" +
                                                "pqccp (99)\n" +
                                                "bgahvfu (54)\n" +
                                                "gotqku (33)\n" +
                                                "vregap (88)\n" +
                                                "qjcqm (138) -> vdkrvi, qoijc\n" +
                                                "phocd (23)\n" +
                                                "lerycoe (84)\n" +
                                                "aidbql (35)\n" +
                                                "qwvmczr (187) -> youpfn, kkukqoj\n" +
                                                "achhc (30)\n" +
                                                "qxnkp (68)\n" +
                                                "znkzp (94) -> otpnx, drtxytc, ntonira, zyxjg\n" +
                                                "ewzryd (92)\n" +
                                                "xxssj (168) -> nhnrpz, rzwfp\n" +
                                                "lnaoiv (70) -> awqat, dnaoe, qombesj, eygaz\n" +
                                                "qzjyi (88)\n" +
                                                "aevhbim (49)\n" +
                                                "jeuzbj (44)\n" +
                                                "msskvkg (60)\n" +
                                                "douvhy (133) -> mqulwk, nnkmf\n" +
                                                "qrfgzm (552) -> lrtds, yrpat, tvjwhhy, atmzoso, dudxud, rqdcuf, xxssj\n" +
                                                "alankuj (75)\n" +
                                                "juymjz (77)\n" +
                                                "gcqaj (69)\n" +
                                                "ozwpmzc (43) -> bknogxz, ldfofo\n" +
                                                "gintpbf (59) -> byckty, tagyci\n" +
                                                "yrhid (222) -> phocd, wtzkvm, kldww, xugyewm\n" +
                                                "keucu (15) -> kwozg, xfmxo, rwepl\n" +
                                                "zicelk (67)\n" +
                                                "xwwxswj (40) -> frnhsjr, mmvszxj, qsmvtif\n" +
                                                "lcfyznt (151) -> klmvmt, bgmmb\n" +
                                                "ehwlw (55) -> tgebda, ehypcwy, xqxyx, vxfci, nxlhjq\n" +
                                                "uegez (150) -> rnjfcg, tusgzei\n" +
                                                "pjaxkr (92)\n" +
                                                "mdprv (179) -> paanydj, vtaejs\n" +
                                                "avjkgl (9)\n" +
                                                "sshfxeu (11) -> goilxo, ltichp\n" +
                                                "alzipi (53) -> cpsce, ezspcab\n" +
                                                "wxoqoa (100) -> mfvul, pwatre\n" +
                                                "trmwq (10)\n" +
                                                "ltmwbs (33)\n" +
                                                "kmdzlmk (235) -> mzauq, ycsbsyn, srqclhj, shhfy, xcycu, zsnatp\n" +
                                                "dfjvh (61)\n" +
                                                "zknesz (39)\n" +
                                                "ezglz (289) -> kyjgf, oaynkf\n" +
                                                "pqixzdw (128) -> nvvca, cwxgqrk, duccgc, sbnsoxi\n" +
                                                "zpczji (60)\n" +
                                                "rathd (135) -> rsbune, wmdbo, uftwml\n" +
                                                "pchccgz (85)\n" +
                                                "rzwfp (17)\n" +
                                                "umgzhmp (150) -> eqibqs, rwgpi, wcuvk\n" +
                                                "ouqtjz (127) -> ejkei, sdgdv\n" +
                                                "sstvew (52)\n" +
                                                "qxhda (96)\n" +
                                                "cvstod (96)\n" +
                                                "rbyiay (94)\n" +
                                                "vwzmkq (63) -> vhjcue, nnbty\n" +
                                                "dtzws (83)\n" +
                                                "nyepy (363) -> jsltf, nuxqskl\n" +
                                                "iiwkm (84) -> fluwt, clcixal\n" +
                                                "ucezr (10)\n" +
                                                "zvtoom (55)\n" +
                                                "fleszz (83)\n" +
                                                "hdtcizc (9)\n" +
                                                "wzatr (57)\n" +
                                                "teqswj (40) -> advhon, qhfxqrr, hieel\n" +
                                                "usuaiv (45)\n" +
                                                "eygdy (86) -> pqtboz, kmodn, dqklqo, tukyh\n" +
                                                "janrdqf (81)\n" +
                                                "jjukf (723) -> vqghhbs, ozwpmzc, htsjndf, wsupp\n" +
                                                "udmez (91)\n" +
                                                "lsvqox (1205) -> tpcvq, fvqvgw, jusfet\n" +
                                                "zjymq (33)\n" +
                                                "wuisqnk (34)\n" +
                                                "pxydes (62)\n" +
                                                "qegmu (84) -> hzcanxq, xfbosce, glyxk, fvlmvtk, akmbqb, lymsa, fbrwdf\n" +
                                                "mckrfxj (38)\n" +
                                                "keylghg (60)\n" +
                                                "dqwdx (215) -> hseaxj, ubxke\n" +
                                                "fzjgh (179) -> bafdzbu, uanvh\n" +
                                                "qsvckew (8)\n" +
                                                "pvhrim (52)\n" +
                                                "mzauq (98) -> sxpan, pjitmnv, ogczchc, aruczxj\n" +
                                                "nxwjvx (53)\n" +
                                                "agufw (229) -> wbbaxr, knrgg\n" +
                                                "urpnw (47) -> khtjh, dflvw, otxphme\n" +
                                                "klmvmt (17)\n" +
                                                "skgwztg (233)\n" +
                                                "ghaxvq (9)\n" +
                                                "sgobq (60) -> lsspa, srgmt, wofung, rathd, joaed, fzjgh, pbkfd\n" +
                                                "qaveutv (44)\n" +
                                                "dnaoe (80) -> vohepl, mymke, paglk, pahwxj\n" +
                                                "edgdvfa (23)\n" +
                                                "mrfmn (94)\n" +
                                                "hovhxsp (31)\n" +
                                                "hqlyg (47) -> aidbql, tfhij, krvyy\n" +
                                                "zuybvj (32)\n" +
                                                "kquxfy (1294) -> srcyajr, neako, vtuqq\n" +
                                                "htsuvhg (253)\n" +
                                                "tagyci (80)\n" +
                                                "ldnnoag (35)\n" +
                                                "qkougo (76)\n" +
                                                "fvmhrf (38)\n" +
                                                "spvcd (84)\n" +
                                                "tcbpqu (70)\n" +
                                                "yzxqp (76)\n" +
                                                "ihmqs (66) -> oydsj, qheany\n" +
                                                "neako (48) -> panao, fcufg\n" +
                                                "dkgmsse (18)\n" +
                                                "zupym (33)\n" +
                                                "pwumvgy (80)\n" +
                                                "ognax (83)\n" +
                                                "oxvwr (203) -> wixlvcp, wqgcqb\n" +
                                                "ysltqk (65) -> mrfmn, hrjgbc\n" +
                                                "dtqzu (61) -> tgnqn, corfkob\n" +
                                                "vmhwy (177) -> yaudo, eqxgwfz\n" +
                                                "pwatre (16)\n" +
                                                "uijtrw (247) -> cbdczg, idjhk\n" +
                                                "stfzaxc (84)\n" +
                                                "refya (15)\n" +
                                                "xfbosce (188) -> rstdh, nqzwt\n" +
                                                "kbrxrks (56)\n" +
                                                "fplihc (88)\n" +
                                                "fkoqh (251) -> ohvifiy, npckah\n" +
                                                "lwfoqny (61)\n" +
                                                "paanydj (39)\n" +
                                                "xzxvwzf (29)\n" +
                                                "bpebim (180) -> vvnohc, jlyaty, kixaco\n" +
                                                "aiunbee (1214) -> fpldxlq, eqmeu, teqswj, ngtkzm, yndyrey, wtbwbpz, eoqtf\n" +
                                                "wrdgs (220)\n" +
                                                "oxxlsk (31)\n" +
                                                "atlrd (269) -> dgszhd, dkgmsse\n" +
                                                "svtwviu (69) -> iiwkm, ieuwo, carbhvi, lzouo, cklpcr, fkkzg, ouubjrl\n" +
                                                "mfvul (16)\n" +
                                                "ndpwgdy (36)\n" +
                                                "rhzco (48)\n" +
                                                "nzetqt (8)\n" +
                                                "xvzlrw (87)\n" +
                                                "utsob (14)\n" +
                                                "rsbune (50)\n" +
                                                "tcgffi (32)\n" +
                                                "cwttq (9) -> mughfl, ponlfyf, tuyyte, ndhsa\n" +
                                                "wejvpzr (29)\n" +
                                                "ozgprze (20)\n" +
                                                "eemnlc (83)\n" +
                                                "omlwg (28)\n" +
                                                "hpmuqvl (37) -> gawck, yeucm\n" +
                                                "ohusizx (9151) -> fsokbvd, oojme, bonjgrt\n" +
                                                "mqllnxu (206)\n" +
                                                "cnqrxk (38)\n" +
                                                "qpjctjw (32)\n" +
                                                "wttpvzh (23)\n" +
                                                "tgnqn (87)\n" +
                                                "eyrfvtl (61)\n" +
                                                "mzzxjcu (27)\n" +
                                                "velktz (145) -> dxzlkz, keylghg\n" +
                                                "hvdhkw (210)\n" +
                                                "zafde (41)\n" +
                                                "qmwvc (558) -> hibxz, xqbvg, bgjzy, mvswhtp\n" +
                                                "knrgg (10)\n" +
                                                "xrbuyn (38)\n" +
                                                "wsupp (35) -> ecgpjx, jiybx\n" +
                                                "krlep (54)\n" +
                                                "gvajgxp (40)\n" +
                                                "yaudo (40)\n" +
                                                "prdkf (96) -> chrqi, tqjlm\n" +
                                                "suxpc (66)\n" +
                                                "pnmfw (51)\n" +
                                                "jldaz (64)\n" +
                                                "rucse (85)\n" +
                                                "ivcedgz (46)\n" +
                                                "zytvsav (21)\n" +
                                                "tytka (53)\n" +
                                                "pfdmmg (11)\n" +
                                                "hmumqsz (47)\n" +
                                                "cncicpd (93)\n" +
                                                "rrixk (27)\n" +
                                                "uzyprc (16)\n" +
                                                "ljctbd (13)\n" +
                                                "llgoq (76) -> rgwpu, movmxq, hvifpbk, hiiqp, kszkv, bjtza, hfttss\n" +
                                                "gqoxv (1646) -> bvikij, dcqpq, kquxfy, qrfgzm, qomxhp\n" +
                                                "apktiv (8441) -> obxrn, kqaksir, itjrw, supnaxw, wuefg, twtcx\n" +
                                                "nicjj (56)\n" +
                                                "nzmaui (18) -> wmxobe, eipmjyb, jovly, tjblqzk\n" +
                                                "ezspcab (84)\n" +
                                                "bclrfac (31)\n" +
                                                "jrcng (318)\n" +
                                                "pbkfd (157) -> pcdvdp, jldaz\n" +
                                                "vmqlqrp (46)\n" +
                                                "ynvqpm (92)\n" +
                                                "rnjfcg (20)\n" +
                                                "qhqnfsp (5)\n" +
                                                "ajozeez (92)\n" +
                                                "shciqu (127) -> ehywag, ajbtn\n" +
                                                "uujpt (29)\n" +
                                                "znooxvq (7)\n" +
                                                "mwblvo (257) -> ixmfiwz, jlcgqt, rmqdolg\n" +
                                                "rrazh (233) -> clsbdm, uavnq\n" +
                                                "ipjbc (92)\n" +
                                                "jovkydi (89)\n" +
                                                "rkfsa (102) -> pestqep, vnvkvb\n" +
                                                "owzwbpn (89)\n" +
                                                "cragbdx (19)\n" +
                                                "vtpldh (19)\n" +
                                                "rplxsw (82)\n" +
                                                "cbvamfw (47) -> wdnebh, vpqqbz\n" +
                                                "vhrxl (7)\n" +
                                                "cqvyvl (122) -> eemnlc, hehbbo\n" +
                                                "nmxmtaa (188) -> bvahtih, asklr\n" +
                                                "kfcgv (32)\n" +
                                                "pztxq (339) -> pqbar, bclrfac\n" +
                                                "gwfrqr (32)\n" +
                                                "dcqpq (1411) -> dqdpop, gtrgqb, lcfyznt\n" +
                                                "ksxixz (9)\n" +
                                                "itjrw (9) -> jjjpzm, mhofo, znljf, wrdgs, dcknzvh\n" +
                                                "omwrb (859) -> pqixzdw, hoqtxuf, weenw\n" +
                                                "rwgpi (20)\n" +
                                                "xoqxg (73)\n" +
                                                "rdyda (5)\n" +
                                                "dolng (83)\n" +
                                                "osvmh (77)\n" +
                                                "pqewl (185) -> hchmn, rhtdtxv, xzgejmu, fumvuu\n" +
                                                "dcknzvh (138) -> pdviq, hnpndnp\n" +
                                                "vjmwqzj (35)\n" +
                                                "zhttn (63)\n" +
                                                "lyuys (284) -> zicelk, joernlg\n" +
                                                "jjjpzm (164) -> vjgvk, yaiinhu\n" +
                                                "siruccf (37)\n" +
                                                "tzkuvl (87)\n" +
                                                "jpbiodh (10)\n" +
                                                "jodrf (56) -> lktgac, ysskib, qkougo\n" +
                                                "egvza (251) -> gotqku, viqlepb\n" +
                                                "jdpcmb (6)\n" +
                                                "ejlgch (133) -> mmoea, vvbcb\n" +
                                                "ecgpjx (88)\n" +
                                                "pdviq (41)\n" +
                                                "igqvq (288)\n" +
                                                "pndcqot (31)\n" +
                                                "kmjfxcf (15)\n" +
                                                "rqhfhc (12)\n" +
                                                "cgbgm (85)\n" +
                                                "jjmfi (33)\n" +
                                                "vpizq (37)\n" +
                                                "zynpfpv (73)\n" +
                                                "vnyllno (37)\n" +
                                                "sfyad (69)\n" +
                                                "sooqm (69)\n" +
                                                "dxdltnx (80) -> xtexo, ohpvt, acjtzxw, pnmfw\n" +
                                                "gcmpmnt (166) -> stqwvs, xmgkswu\n" +
                                                "jwgrqmj (44)\n" +
                                                "gcksx (73)\n" +
                                                "uswphji (1472) -> nzweur, pocxcw, xdlyd, joczsir, kymbpe, rhwgdsv, omwrb\n" +
                                                "lhifvp (49)\n" +
                                                "sgfco (305)\n" +
                                                "wqgcqb (12)\n" +
                                                "rgjxp (116) -> nujppls, eumzi\n" +
                                                "omzlzx (66)\n" +
                                                "jeplz (96) -> gpysit, gzmagb\n" +
                                                "bgjzy (78) -> ibmiu, ghaxvq, lkopm, khrqmbo\n" +
                                                "kvqsn (69) -> bpdixmv, knjlz, nmmtdv, edzgraw\n" +
                                                "ugkuxzz (314)\n" +
                                                "pryjaeo (21)\n" +
                                                "jzpwsg (78) -> paegovu, bxifcld, oijrg, wyftg\n" +
                                                "flufot (182) -> ftoskhn, afzlar\n" +
                                                "cmqaaw (83)\n" +
                                                "fvqvgw (26) -> ymfls, lgtpaqk, cumus\n" +
                                                "gurxxfd (46) -> qaveutv, bwtusip, jeuzbj, qifuph\n" +
                                                "jqtlcm (380) -> njeahp, sfyoyp\n" +
                                                "bywpbd (215) -> qrfuvjh, nrczybn\n" +
                                                "pcpnk (28)\n" +
                                                "pnjbsm (69)\n" +
                                                "lhxycw (161) -> achhc, ttwnws\n" +
                                                "qczhlyf (14)\n" +
                                                "sldytqh (49)\n" +
                                                "fmjhlia (20)\n" +
                                                "soqvass (53)\n" +
                                                "qptfj (21)\n" +
                                                "izuebwg (37)\n" +
                                                "iaafo (1335) -> iggtk, gkjbikb, gcvpqk\n" +
                                                "bkzdepq (56)\n" +
                                                "nqzwt (21)\n" +
                                                "frnhsjr (71)\n" +
                                                "nfwlplx (92)\n" +
                                                "egsgwch (279) -> jxwyzy, sbnot\n" +
                                                "ntonira (81)\n" +
                                                "ahrfot (9)\n" +
                                                "zjbiqnt (54)\n" +
                                                "tpozmfd (27)\n" +
                                                "jopepd (27)\n" +
                                                "kkukqoj (38)\n" +
                                                "panao (88)\n" +
                                                "szsntp (88) -> uvvqcxz, vboha, xgzexud, aaqcpt\n" +
                                                "lfqca (65) -> kieka, rfqenw, srbuc\n" +
                                                "ttwnws (30)\n" +
                                                "iobcvl (20)\n" +
                                                "gmeueu (45)\n" +
                                                "jazkpl (32)\n" +
                                                "carbhvi (118) -> vxrzo, ujlhns\n" +
                                                "jlyaty (11)\n" +
                                                "jwbxyd (75)\n" +
                                                "mlmzsqc (78)\n" +
                                                "sqpdsk (86)\n" +
                                                "gkijw (268) -> hgbkwjv, stmzb\n" +
                                                "sebxl (52)\n" +
                                                "anwxvv (59) -> qnjpz, kbibi\n" +
                                                "cylfwm (81)\n" +
                                                "sbnot (13)\n" +
                                                "cdcnp (5)\n" +
                                                "sohzsx (80)\n" +
                                                "gfmgl (47)\n" +
                                                "cbdczg (47)\n" +
                                                "uamje (82)\n" +
                                                "phrume (20)\n" +
                                                "jhpijl (185) -> mojjl, yhjopn\n" +
                                                "czzpk (17)\n" +
                                                "mwpdil (37)\n" +
                                                "lizssx (47)\n" +
                                                "otxphme (86)\n" +
                                                "vvnohc (11)\n" +
                                                "xmusk (10)\n" +
                                                "pqgpuv (210) -> lnnwiq, qqosg\n" +
                                                "iqumjrz (19)\n" +
                                                "khtjh (86)\n" +
                                                "sqfgpm (41)\n" +
                                                "qpqplm (30)\n" +
                                                "pqlav (8)\n" +
                                                "nzhprt (93) -> sohzsx, vaylgz\n" +
                                                "iehfo (624) -> fcsfrg, cbvamfw, dtqzu\n" +
                                                "vhfwgvx (83)\n" +
                                                "tbkhho (97)\n" +
                                                "uqymxu (58) -> egqmgr, izuebwg\n" +
                                                "xzgejmu (188) -> cwiwn, vtadj, tcbpqu\n" +
                                                "gjnnmvb (20)\n" +
                                                "ppmlbky (544) -> kvqsn, kcgui, chetpy, pztxq\n" +
                                                "jqqojdl (33)\n" +
                                                "qksclw (69) -> inxivh, dxbxha, irjvpam, syuoewb\n" +
                                                "axxkh (222)\n" +
                                                "tnccv (259) -> wttpvzh, edgdvfa\n" +
                                                "cumus (75)\n" +
                                                "jxkofob (1875) -> mrizfl, zgqsgm, bclse, ciojx, rgjxp, yifny\n" +
                                                "uydtye (8)\n" +
                                                "tuyyte (82)\n" +
                                                "twgbxu (63)\n" +
                                                "ulpkj (40)\n" +
                                                "lunefek (35)\n" +
                                                "pestqep (60)\n" +
                                                "kvxnjmq (25)\n" +
                                                "siitl (61)\n" +
                                                "chutuh (13)\n" +
                                                "gtjbuae (71)\n" +
                                                "fbrwdf (17) -> jzjrtvd, gtjbuae, zsnge\n" +
                                                "tukyh (71) -> ggzym, rfvehkx\n" +
                                                "xqpffoe (68) -> elthna, mwpdil, vpizq\n" +
                                                "iepmwr (176) -> irsfgz, rbyiay\n" +
                                                "lntikva (47)\n" +
                                                "kmodn (253)\n" +
                                                "ufsmed (81)\n" +
                                                "psrqv (54)\n" +
                                                "xluwv (30)\n" +
                                                "qombesj (380) -> rdghpyb, ivcedgz\n" +
                                                "shhfy (76) -> zynpfpv, kppxrk\n" +
                                                "fvlmvtk (130) -> ilpuzq, jzndr\n" +
                                                "gdqtqg (155) -> lhifvp, jfaca\n" +
                                                "osgjrb (69)\n" +
                                                "uqjge (88) -> nzetqt, nitvw, wxemcge, uydtye\n" +
                                                "ppafb (30)\n" +
                                                "opduu (38)\n" +
                                                "fpank (10)\n" +
                                                "sngnjdu (15)\n" +
                                                "ndidblx (52)\n" +
                                                "asklr (19)\n" +
                                                "wmxobe (61)\n" +
                                                "vvnzr (48)\n" +
                                                "usggwvu (375)\n" +
                                                "sukktk (202) -> oevbo, sitjrw\n" +
                                                "mqztoa (26) -> dzjsx, wzatr\n" +
                                                "kfxhl (40)\n" +
                                                "jsjexer (258) -> ljctbd, chutuh\n" +
                                                "bremy (70)\n" +
                                                "xugyewm (23)\n" +
                                                "djrrc (39) -> egcat, wdazzdu, zjbiqnt\n" +
                                                "juqbdco (144) -> vggsia, tytka\n" +
                                                "rfouw (28) -> yxzzaaq, zbfut, mpwldri, ljmve\n" +
                                                "svngfr (83) -> odgzsnk, rzrzage, lbzddgt, hvdpzbv\n" +
                                                "viqlepb (33)\n" +
                                                "pgsokae (63)\n" +
                                                "cobwyky (76)\n" +
                                                "zgjoaiw (25)\n" +
                                                "ohvifiy (6)\n" +
                                                "simmjy (65) -> mlksi, mfawmsq\n" +
                                                "zrqqtx (45)\n" +
                                                "yrpat (120) -> zlkzyr, zafde\n" +
                                                "nevkec (53)\n" +
                                                "gvxhl (125) -> liymk, psrqv\n" +
                                                "ohpvt (51)\n" +
                                                "kmqurp (155) -> ycyyvdy, slmxb\n" +
                                                "acrsmhw (99) -> cncicpd, tiwakam\n" +
                                                "yrdsj (149) -> mmtyhkd, omshqjl, pryjaeo, zytvsav\n" +
                                                "pahwxj (98)\n" +
                                                "nhnrpz (17)\n" +
                                                "mfzvywf (14)\n" +
                                                "fhphiyb (45183) -> ixktgj, zfzum, yzyzmzw\n" +
                                                "eduwet (1794) -> tzkuvl, jcmte, rndomrv\n" +
                                                "akrgqe (74)\n" +
                                                "bzjctqm (115) -> dphcbfr, sauzcee\n" +
                                                "xqbvg (104) -> cdcnp, wixfh\n" +
                                                "ljzuyyk (62)\n" +
                                                "egusv (173) -> qpxbow, gvajgxp\n" +
                                                "grmhpg (75)\n" +
                                                "gtbpbl (252)\n" +
                                                "fkdukrv (331) -> zbrbb, zsoro\n" +
                                                "aondpve (53)\n" +
                                                "vgsnxlm (23)\n" +
                                                "hcptw (44)\n" +
                                                "zkgoa (77)\n" +
                                                "dasyq (66)\n" +
                                                "skumcr (55)\n" +
                                                "afatio (30) -> hjxcpi, qmddtb, ppafb\n" +
                                                "ioobamp (9)\n" +
                                                "wrprrev (63)\n" +
                                                "nrczybn (9)\n" +
                                                "hoxdnl (32)\n" +
                                                "ndcfy (19)\n" +
                                                "tdecuga (85)\n" +
                                                "ugqqv (70) -> akrgqe, aeawrmy, ozjbwv\n" +
                                                "ravjm (83)\n" +
                                                "tsizsce (52)\n" +
                                                "uyopxvt (56)\n" +
                                                "djgzb (79) -> gpysm, rucse\n" +
                                                "ozbfh (64)\n" +
                                                "rwepl (73)\n" +
                                                "vkfrqct (56)\n" +
                                                "mansh (22)\n" +
                                                "bnsivw (336) -> vobnpuq, hoxdnl\n" +
                                                "omshqjl (21)\n" +
                                                "lktgac (76)\n" +
                                                "hgrua (66)\n" +
                                                "vrxeemw (49) -> vvnhe, nyejrrv\n" +
                                                "ydfajlk (88) -> qgjqyh, alneqju, jmchsu\n" +
                                                "ewjrko (167) -> kbrxrks, cygdj\n" +
                                                "oeftx (49) -> bpebim, sdbmop, nlpmbrd, yulga, qtlzten, hidrx\n" +
                                                "ypogtw (85)\n" +
                                                "eoqtf (97) -> ktejrze, osgjrb\n" +
                                                "cbbcj (46)\n" +
                                                "dvlyc (16) -> arkedwb, nzhprt, zjaqq, cjxyt, gdqtqg, jhpijl, egusv\n" +
                                                "tvjwhhy (120) -> tkjeu, vaeuo\n" +
                                                "cahxjyq (52)\n" +
                                                "muarkn (85)\n" +
                                                "zzjuf (95) -> rqkfkxw, lizssx\n" +
                                                "cygdj (56)\n" +
                                                "vlagh (5)\n" +
                                                "vohepl (98)\n" +
                                                "pgprg (152) -> jqdmk, bxefs\n" +
                                                "yrwyc (5) -> ocpngbz, ybfew, nyepy, cmcto\n" +
                                                "asfqik (180) -> orcyokv, tuyzi\n" +
                                                "jcyciyq (12)\n" +
                                                "twnfzz (149) -> vbateme, olydb\n" +
                                                "jofvyvx (25)\n" +
                                                "tazfdb (43)\n" +
                                                "jcmte (87)\n" +
                                                "ttolm (173) -> vmqlqrp, vffew\n" +
                                                "fndeqk (27)\n" +
                                                "xydxd (56)\n" +
                                                "elthna (37)\n" +
                                                "uspimc (85)\n" +
                                                "zatwq (66)\n" +
                                                "mwpbyo (6)\n" +
                                                "joaed (205) -> ycxlhqo, mgzox, nmemj, ljmkz\n" +
                                                "vtadj (70)\n" +
                                                "ilpuzq (50)\n" +
                                                "ubksf (106) -> nrbcaqo, shnrfq\n" +
                                                "mmnejdx (10)\n" +
                                                "srqclhj (90) -> jqqojdl, krzjli, ltmwbs, mtrnyd\n" +
                                                "rpegyn (23)\n" +
                                                "nzsnkla (265)\n" +
                                                "zfhkfwn (7)\n" +
                                                "hrjgbc (94)\n" +
                                                "stqwvs (28)\n" +
                                                "etkdg (38)\n" +
                                                "fumvuu (86) -> xcldsl, memrqz, ryfse, vauwilt\n" +
                                                "uavnq (10)\n" +
                                                "yaiinhu (28)\n" +
                                                "mlksi (92)\n" +
                                                "oyguh (32) -> ipxkky, lqmdutk, hrtgwt, kvxnjmq\n" +
                                                "ceeem (25)\n" +
                                                "pqbar (31)\n" +
                                                "aeawrmy (74)\n" +
                                                "fcufg (88)\n" +
                                                "hjnhdkp (27)\n" +
                                                "xmxzvhr (14) -> cvstod, jxcnmmo\n" +
                                                "mketjaw (45)\n" +
                                                "srbuc (80)\n" +
                                                "qqosg (20)\n" +
                                                "ynrctr (140)\n" +
                                                "kbibi (71)\n" +
                                                "lalfu (50)\n" +
                                                "iamrpx (96)\n" +
                                                "xgfsqq (309) -> qwvmczr, ladcna, fkoqh\n" +
                                                "dobmve (90)\n" +
                                                "nvvca (15)\n" +
                                                "vtaejs (39)\n" +
                                                "xgzexud (79)\n" +
                                                "tmvkuob (15)\n" +
                                                "foxjx (60)\n" +
                                                "ladcna (97) -> hbdwzm, cmqaaw\n" +
                                                "klnew (68)\n" +
                                                "vtdwe (37)\n" +
                                                "eayhoi (58) -> tvgytpm, pvlirjn\n" +
                                                "nccoxir (52)\n" +
                                                "wibfie (90) -> uqymxu, oyguh, wxoqoa, alomcle, fvikm, kykfb, ebgsk\n" +
                                                "yhcsc (34)\n" +
                                                "ptzbutd (38)\n" +
                                                "xmgkswu (28)\n" +
                                                "ajhio (301) -> jjmfi, mfecx, zjymq\n" +
                                                "lasluxv (87) -> etkdg, mckrfxj\n" +
                                                "msyvug (76)\n" +
                                                "weenw (188)\n" +
                                                "drtrgwp (185) -> hmumqsz, lntikva\n" +
                                                "gyojd (214)\n" +
                                                "zwrfiyf (17)\n" +
                                                "gquil (84)\n" +
                                                "erghvss (45)\n" +
                                                "mqmgirb (251) -> buffpzu, qpwiok\n" +
                                                "xaali (31)\n" +
                                                "clcixal (65)\n" +
                                                "pyxgmtu (169) -> hjnhdkp, jopepd, fndeqk\n" +
                                                "grgsn (61)\n" +
                                                "finkdao (78)\n" +
                                                "njeahp (10)\n" +
                                                "hidrx (175) -> ineay, vtpldh\n" +
                                                "qcyypa (93)\n" +
                                                "gnwlorj (48)\n" +
                                                "xjjdapk (64)\n" +
                                                "vxrtejs (30)\n" +
                                                "uukshmq (63)\n" +
                                                "hzcanxq (214) -> peuadz, pqlav\n" +
                                                "ptizsk (10) -> cbirs, syurke, ihpmp\n" +
                                                "cjoya (196) -> pcpnk, dbuccip\n" +
                                                "qpaei (86) -> djyxrkb, cupbfut\n" +
                                                "tjblqzk (61)\n" +
                                                "xjnhqlg (92)\n" +
                                                "qscpjx (39)\n" +
                                                "xptjtlm (108) -> utsob, lmxnloe, vrzbmt\n" +
                                                "rgwpu (161) -> xjuoid, oszlto, mketjaw\n" +
                                                "erdxj (299) -> mdprv, zdtvktq, labnsw, vmhwy\n" +
                                                "stmzb (32)\n" +
                                                "vxjjxhz (49)\n" +
                                                "xxlbk (92)\n" +
                                                "fxwez (7)\n" +
                                                "hbdwzm (83)\n" +
                                                "bjdtdn (61)\n" +
                                                "wnfqg (99) -> ravjm, dolng\n" +
                                                "sauzcee (67)\n" +
                                                "nkfrt (98)\n" +
                                                "rfvehkx (91)\n" +
                                                "fnzjtvw (88)\n" +
                                                "wdhmsi (45)\n" +
                                                "slmxb (17)\n" +
                                                "dkoxq (128) -> hvpcvdf, mdkes\n" +
                                                "qheany (80)\n" +
                                                "lpziczm (229) -> xydxd, fuqvw\n" +
                                                "gzmagb (22)\n" +
                                                "bgjngh (20)\n" +
                                                "krfgye (51) -> gzvjxk, dvlyc, niwzp, olqbic, iaixlte, tycqst, kfqrgj\n" +
                                                "dcwfs (99)\n" +
                                                "ixktgj (955) -> eabhh, iqvhov, lemnz\n" +
                                                "mbtsi (300) -> gbixdw, lalfu\n" +
                                                "dqklqo (57) -> jkaxk, nkfrt\n" +
                                                "qwsan (44)\n" +
                                                "iggtk (235) -> gyuyb, cjjbqxl\n" +
                                                "ascyv (15)\n" +
                                                "gtrgqb (17) -> coaznz, spvcd\n" +
                                                "awoedy (34)\n" +
                                                "mtrnyd (33)\n" +
                                                "wofung (133) -> ptzbutd, jlpxjeo, cnqrxk, crrfxfn\n" +
                                                "dpiyhv (86) -> tsizsce, gfdyf\n" +
                                                "surri (214)\n" +
                                                "tusgzei (20)\n" +
                                                "kzcyjtb (78) -> sqmfis, ppfmc, ldnnoag\n" +
                                                "memrqz (78)\n" +
                                                "javiioo (87) -> gnwlorj, tmbtipi\n" +
                                                "dzqrtc (206) -> zbwxa, ykpsfj\n" +
                                                "jtpgzp (31)\n" +
                                                "yndyrey (189) -> iuzvl, poinih\n" +
                                                "hkazlkt (235) -> adxeaf, rkfsa, yzbccbx, lkdkyk, gcmpmnt, zdqcu\n" +
                                                "bjqkaya (78) -> szsntp, nandmg, kjlxeat, kywmnbd\n" +
                                                "guywt (55)\n" +
                                                "qwcrc (63)\n" +
                                                "asdlfku (80)\n" +
                                                "vhjcue (81)\n" +
                                                "hiiqp (148) -> lhvyfsb, dltungt, tbrznk, vnyllno\n" +
                                                "deczzuu (92)\n" +
                                                "mymke (98)\n" +
                                                "subwna (61)\n" +
                                                "kmcad (1022) -> bzjctqm, akniuo, simmjy\n" +
                                                "uufxdt (328) -> hyfuy, iepmwr, asfqik, qxkas, nayudfl\n" +
                                                "ejkei (89)\n" +
                                                "afzlar (34)\n" +
                                                "buffpzu (33)\n" +
                                                "kyjgf (8)\n" +
                                                "bigkiu (748) -> uegcs, umgzhmp, frinpfj, nurclfr, hvdhkw\n" +
                                                "ryfse (78)\n" +
                                                "olztzl (25)\n" +
                                                "tgkbxa (33)\n" +
                                                "nktmu (86)\n" +
                                                "zlkzyr (41)\n" +
                                                "pmgwwzy (191) -> rgyco, qptfj\n" +
                                                "jfmts (56)\n" +
                                                "zacsvwk (43)\n" +
                                                "znljf (175) -> refya, tmvkuob, sngnjdu\n" +
                                                "kwozg (73)\n" +
                                                "eklqi (90)\n" +
                                                "cdwkezv (62)\n" +
                                                "ugmlsij (121) -> kpghxz, kravhjd\n" +
                                                "awqat (372) -> fdmbkt, znkchkk\n" +
                                                "ydgzjs (110) -> ymyzead, yzxqp\n" +
                                                "tugrmnp (60)\n" +
                                                "fmarl (5688) -> xbtswv, jvqwi, slgiv, uswphji, syjvwzt\n" +
                                                "memkrd (7478) -> nivpffu, bjqkaya, qegmu\n" +
                                                "jvfmwp (27)\n" +
                                                "qhqyt (66)\n" +
                                                "lbzddgt (73)\n" +
                                                "qsmvtif (71)\n" +
                                                "ytmpzku (49) -> jwgrqmj, nfrtom, lfiqwye, jkvduo\n" +
                                                "tdgel (61)\n" +
                                                "shnrfq (45)\n" +
                                                "hhrqz (129) -> rrixk, jvfmwp\n" +
                                                "ojatf (9518) -> qmwvc, wibfie, dnycw\n" +
                                                "yxzzaaq (55)\n" +
                                                "wjipa (1180) -> mqllnxu, xmxzvhr, qbynkmw\n" +
                                                "cwxgqrk (15)\n" +
                                                "aotajs (133) -> ucezr, mmnejdx, jpbiodh\n" +
                                                "lsspa (60) -> paldf, grmhpg, exjsjxd\n" +
                                                "ineoncq (11)\n" +
                                                "eipmjyb (61)\n" +
                                                "fjgsw (29)\n" +
                                                "wnwsbdq (50)\n" +
                                                "hdgvs (37) -> msyvug, bntdh, sjxaxv\n" +
                                                "npckah (6)\n" +
                                                "swqkqgz (19)\n" +
                                                "eabhh (379) -> jzpwsg, bkwcwf, mwblvo\n" +
                                                "ggaxx (87)\n" +
                                                "rjvfwcu (64)\n" +
                                                "bwtusip (44)\n" +
                                                "slgjon (63)\n" +
                                                "vlpqaxo (66)\n" +
                                                "mmoea (11)\n" +
                                                "xnltw (93)\n" +
                                                "tgpxvyr (37)\n" +
                                                "phdcpp (63)\n" +
                                                "dltungt (37)\n" +
                                                "ljvrcj (83)\n" +
                                                "upaqlj (44) -> cobwyky, pngubp\n" +
                                                "hwriv (97)\n" +
                                                "hopjmyt (62)\n" +
                                                "sizmuwa (180) -> sooqm, sfyad\n" +
                                                "jzndr (50)\n" +
                                                "ppmrgga (222) -> cvvncju, xmusk, trmwq\n" +
                                                "uvswv (90)\n" +
                                                "xstrla (46)\n" +
                                                "pcdvdp (64)\n" +
                                                "kszkv (164) -> hgrua, qhqyt\n" +
                                                "niwzp (855) -> nnhknbl, ichznto, llmmm, hpmuqvl\n" +
                                                "kybegv (96)\n" +
                                                "rxcbsdp (30) -> ynvqpm, pjaxkr\n" +
                                                "ihpmp (85)\n" +
                                                "hseaxj (51)\n" +
                                                "fuzhuf (38)\n" +
                                                "plbtdq (633) -> gkuma, jrcng, dkoxq, vtylgti, qifoay, sizmuwa, pjxttn\n" +
                                                "esooc (151) -> vtdwe, ezdiq\n" +
                                                "jvqwi (33) -> csaqixs, rnlaw, hvkhvwl, rkpcoen, nptoou, ypvztl\n" +
                                                "luqyr (81)\n" +
                                                "ggzym (91)\n" +
                                                "fcsfrg (113) -> siitl, dkntzn\n" +
                                                "nnbbrbf (135) -> uspimc, xkzgz\n" +
                                                "cwiwn (70)\n" +
                                                "zragt (58)\n" +
                                                "glyxk (22) -> pvhrim, ndidblx, sebxl, sstvew\n" +
                                                "rhwgdsv (481) -> ugkuxzz, yyjqegu, yrhid\n" +
                                                "bmltf (23)\n" +
                                                "gfdyf (52)\n" +
                                                "cbirs (85)\n" +
                                                "xhtzti (21)\n" +
                                                "advhon (65)\n" +
                                                "xcrkb (864) -> ugmlsij, jpkwter, ejlgch\n" +
                                                "kfqrgj (347) -> igqvq, cqvyvl, jzgzd, ashxu, clwwv\n" +
                                                "ouubjrl (36) -> iodveqh, wanom\n" +
                                                "nptoou (269) -> yrdsj, bywpbd, lmcqig, skgwztg, suoiohi, gvxhl, rgdvmy\n" +
                                                "jqdmk (22)\n" +
                                                "ljmkz (20)\n" +
                                                "dxzlkz (60)\n" +
                                                "svhqwim (9)\n" +
                                                "nurclfr (30) -> usuaiv, zyjxpjz, devljb, erghvss\n" +
                                                "vdzuw (146) -> ostrl, lmvvs\n" +
                                                "fsokbvd (262) -> owmjbhg, sshfxeu, zufoz\n" +
                                                "cdvkf (6)\n" +
                                                "lrtds (202)\n" +
                                                "ybfew (377) -> zuybvj, bvnjiou\n" +
                                                "lfiqwye (44)\n" +
                                                "htbjl (57) -> czdpe, gcqaj\n" +
                                                "cjjbqxl (18)\n" +
                                                "vucfp (53)\n" +
                                                "bnvlsm (51)\n" +
                                                "ybekxtf (10703) -> erylwj, xgfsqq, eygdy, dinlw\n" +
                                                "ashxu (96) -> ctinwus, ypdpmwi\n" +
                                                "qpwiok (33)\n" +
                                                "nrdlfop (84)\n" +
                                                "sbhiqhs (27) -> qxnkp, klnew\n" +
                                                "ujlhns (48)\n" +
                                                "ostrl (22)\n" +
                                                "vmjbgo (155) -> udmez, jefztzv\n" +
                                                "rkaxx (27)\n" +
                                                "pocxcw (823) -> blhgy, xptjtlm, kerjqr, ekfewi\n" +
                                                "gkuma (134) -> kvyjyt, foabep\n" +
                                                "ugrhs (32) -> mansh, hpkvfr, ojqia\n" +
                                                "gbixdw (50)\n" +
                                                "phkthld (75)\n" +
                                                "mofyda (109) -> finkdao, mlmzsqc\n" +
                                                "lxucxpm (73) -> iytknc, qhxmh, eltbyz, dfjvh\n" +
                                                "qgjqyh (77)\n" +
                                                "ucxgom (249)\n" +
                                                "mmufeg (13) -> gcksx, oybdjt, xoqxg, masykz\n" +
                                                "yexxg (319)\n" +
                                                "bvahtih (19)\n" +
                                                "lesmi (204) -> qwsan, hcptw\n" +
                                                "pmbnia (94) -> jsjexer, qjcqm, ftegwk, dxdltnx, negkd, jodrf\n" +
                                                "knmac (36)\n" +
                                                "hnpndnp (41)\n" +
                                                "qoijc (73)\n" +
                                                "lemnz (60) -> egvza, mqmgirb, dqwdx, whglbyy, lxucxpm\n" +
                                                "ihtfh (116) -> fplihc, vregap\n" +
                                                "lmxnloe (14)\n" +
                                                "whglbyy (201) -> vnkqnhh, zragt\n" +
                                                "vbateme (50)\n" +
                                                "inxav (77)\n" +
                                                "sykwd (860) -> jeplz, sttlom, ynrctr, cumfrfc\n" +
                                                "aaqcpt (79)\n" +
                                                "mwpatsx (64) -> nrdlfop, lerycoe, mygcpku, uusiaqf\n" +
                                                "uanvh (53)\n" +
                                                "pvlirjn (49)\n" +
                                                "kerjqr (150)\n" +
                                                "wrabgy (32)\n" +
                                                "xjzpum (148) -> vjmwqzj, uwzvy, vwbxg\n" +
                                                "tycqst (1112) -> ytmpzku, vwzmkq, esooc\n" +
                                                "gxxzwq (7)\n" +
                                                "knjbw (27)\n" +
                                                "hpkvfr (22)\n" +
                                                "xappjar (85)\n" +
                                                "oybdjt (73)\n" +
                                                "qmddtb (30)\n" +
                                                "krvyy (35)\n" +
                                                "mughfl (82)\n" +
                                                "hoqtxuf (74) -> xrbuyn, imyvlyt, fvmhrf\n" +
                                                "xtexo (51)\n" +
                                                "bknogxz (84)\n" +
                                                "rreqg (144) -> nccoxir, cahxjyq\n" +
                                                "icpwoof (172) -> wxhsqe, svhqwim\n" +
                                                "kszyl (113) -> sqfgpm, xmvdh\n" +
                                                "zyjxpjz (45)\n" +
                                                "ipxkky (25)\n" +
                                                "jxcnmmo (96)\n" +
                                                "ghkdvw (72)\n" +
                                                "cwphzk (25)\n" +
                                                "mgzox (20)\n" +
                                                "gcvpqk (143) -> ozbfh, opkvs\n" +
                                                "bompiu (25)\n" +
                                                "ckisc (103) -> alankuj, phkthld\n" +
                                                "ngtkzm (67) -> vkfrqct, usvkq, jfmts\n" +
                                                "qifoay (318)\n" +
                                                "rkpcoen (1788) -> uyopxvt, bkzdepq\n" +
                                                "vtuqq (30) -> tbkhho, xhzylb\n" +
                                                "ekfewi (96) -> knjbw, tpozmfd\n" +
                                                "paldf (75)\n" +
                                                "zghrr (25)\n" +
                                                "ggllv (66)\n" +
                                                "vlfpuo (32)\n" +
                                                "sdgdv (89)\n" +
                                                "osryil (62)\n" +
                                                "puexzf (36)\n" +
                                                "smrvw (39)\n" +
                                                "ozjbwv (74)\n" +
                                                "naglm (31)\n" +
                                                "aewie (20)\n" +
                                                "etoxfc (59) -> uxdeg, hcceg, ppmlbky, uufxdt, qbcscs, llgoq, iaafo\n" +
                                                "wxemcge (8)\n" +
                                                "xwkoc (63) -> ijcfw, aondpve, nevkec\n" +
                                                "byckty (80)\n" +
                                                "kvyjyt (92)\n" +
                                                "pkmmfc (54)\n" +
                                                "sxnsqj (9)\n" +
                                                "wtzkvm (23)\n" +
                                                "kfcowx (352) -> edoycls, pqdfbrl, nxdkpuh, acrsmhw, rrkqend\n" +
                                                "ngthpc (51)\n" +
                                                "nkycb (9)\n" +
                                                "otpnx (81)\n" +
                                                "jusfet (39) -> kivcyus, nxwjvx, vucfp, soqvass\n" +
                                                "mvswhtp (28) -> tazfdb, mzlmr\n" +
                                                "exjsjxd (75)\n" +
                                                "ugkxkqe (159) -> qbdafi, htdwe, olztzl\n" +
                                                "pikvdx (82)\n" +
                                                "vnvkvb (60)\n" +
                                                "sitjrw (23)\n" +
                                                "yyjqegu (94) -> guywt, skumcr, whoqvq, slrdn\n" +
                                                "qnrjqj (61)\n" +
                                                "szfxhin (17)\n" +
                                                "iiznokx (90)\n" +
                                                "vbpyoqo (97)\n" +
                                                "qwdhdrk (7)\n" +
                                                "iqvhov (120) -> atlrd, mmufeg, ouqtjz, xgitr, ezglz\n" +
                                                "wdnebh (94)\n" +
                                                "ylidl (82) -> wejvpzr, jlshk\n" +
                                                "qsfpaj (34)\n" +
                                                "qbcscs (1680) -> yazsie, eayhoi, btqebbp\n" +
                                                "auiiuv (78)\n" +
                                                "ixmfiwz (55)\n" +
                                                "hcceg (1083) -> dkoxwi, iwsknb, fkdukrv\n" +
                                                "kqaksir (152) -> ydfajlk, tyvhfhz, yexxg\n" +
                                                "wixlvcp (12)\n" +
                                                "tfhij (35)\n" +
                                                "vnkqnhh (58)\n" +
                                                "dkntzn (61)\n" +
                                                "oggnstj (279) -> ydgzjs, havdbe, dzqrtc, nzmaui\n" +
                                                "yzyzmzw (583) -> yrwyc, suiyl, kmcad\n" +
                                                "hfttss (5) -> xatua, hwriv, vbpyoqo\n" +
                                                "kieka (80)\n" +
                                                "czdpe (69)\n" +
                                                "vxrzo (48)\n" +
                                                "mpmue (9)\n" +
                                                "ujsbt (68)\n" +
                                                "oijrg (86)\n" +
                                                "vaeuo (41)\n" +
                                                "qbynkmw (114) -> mgyhaax, cbbcj\n" +
                                                "srgmt (165) -> msskvkg, foxjx\n" +
                                                "ycxlhqo (20)\n" +
                                                "pmfprs (20)\n" +
                                                "zbsxee (35)\n" +
                                                "ypvztl (1363) -> xqpffoe, neyeo, lccoo\n" +
                                                "hwrwnh (90)\n" +
                                                "szwpt (29)\n" +
                                                "mhofo (66) -> inxav, osvmh\n" +
                                                "masykz (73)\n" +
                                                "gawck (98)\n" +
                                                "drtxytc (81)\n" +
                                                "wyftg (86)\n" +
                                                "ssvsso (22)\n" +
                                                "koeqohh (275) -> zupym, hxeoxk\n" +
                                                "kcgui (335) -> kguwwze, gcefq\n" +
                                                "olqbic (911) -> ihtfh, ugqqv, lesmi\n" +
                                                "sttlom (62) -> zknesz, gethyvd\n" +
                                                "acjtzxw (51)\n" +
                                                "supnaxw (194) -> iqsztjd, urpnw, opowpvm\n" +
                                                "jzjrtvd (71)\n" +
                                                "rbzqabo (6)\n" +
                                                "keoaqjb (59) -> jqtlcm, wdhbym, mwpatsx, mbtsi, bnsivw, zqurr, ajhio\n" +
                                                "kkkjsil (39)\n" +
                                                "jzgzd (188) -> zorvsm, ainstbs\n" +
                                                "iitweo (96) -> ckisc, ysltqk, zosskdz, xjzpum, rrazh, htsuvhg, xwwxswj\n" +
                                                "xyzbni (58) -> xnltw, lnufi\n" +
                                                "rgdvmy (53) -> hwrwnh, eklqi\n" +
                                                "hhdzz (227) -> cragbdx, iqumjrz\n" +
                                                "mcjgfx (68)\n" +
                                                "jlpxjeo (38)\n" +
                                                "zfzum (16) -> lnaoiv, qkhtsa, lsvqox\n" +
                                                "njatvu (26) -> ehtsbv, hkazlkt, tvgwgq, zktmxll, jjukf, kmdzlmk, svtwviu\n" +
                                                "wdsbi (98)\n" +
                                                "ieuwo (196) -> hdtcizc, ggpjxwv\n" +
                                                "tuyzi (92)\n" +
                                                "dkoxwi (35) -> pwumvgy, asdlfku, aedcmjb, tyuhzom\n" +
                                                "ichznto (221) -> cdvkf, jdpcmb\n" +
                                                "tyvhfhz (179) -> nystxqv, caocs, zbsxee, lunefek\n" +
                                                "uxdeg (443) -> eewnnkx, dryngd, lpziczm, koeqohh, uijtrw\n" +
                                                "egcat (54)\n" +
                                                "kvqspmf (36)\n" +
                                                "ydmrd (90)\n" +
                                                "syurke (85)\n" +
                                                "tkeuvp (159) -> jtpgzp, bfcdy\n" +
                                                "ypdpmwi (96)\n" +
                                                "nmemj (20)\n" +
                                                "eewnnkx (341)\n" +
                                                "bafdzbu (53)\n" +
                                                "wgivp (71)\n" +
                                                "tvgwgq (835) -> prdkf, pnmvk, xyzbni\n" +
                                                "slgiv (7452) -> oeftx, erdxj, oggnstj\n" +
                                                "gpogy (61)\n" +
                                                "xdrge (889) -> shciqu, aotajs, douvhy, lasluxv, sbhiqhs, elgyjo\n" +
                                                "vbdcxx (93)\n" +
                                                "oydsj (80)\n" +
                                                "pjxttn (168) -> jwbxyd, isymgjd\n" +
                                                "edkwqih (60)\n" +
                                                "wanom (89)\n" +
                                                "hqzay (92)\n" +
                                                "xwfbb (20)\n" +
                                                "phyzvno (20)\n" +
                                                "glrua (69)\n" +
                                                "ijcfw (53)\n" +
                                                "alomcle (112) -> fpank, rfwvc\n" +
                                                "lmcqig (71) -> ufsmed, cylfwm\n" +
                                                "ltichp (80)\n" +
                                                "tzltv (63)\n" +
                                                "thknml (89) -> luqyr, janrdqf, wkxkv\n" +
                                                "zsnatp (118) -> orwbdwn, tsiyp\n" +
                                                "zoijv (130)\n" +
                                                "aynpr (63)\n" +
                                                "isymgjd (75)\n" +
                                                "pqdfbrl (117) -> nicjj, cdrhm, mdddafe\n" +
                                                "bonjgrt (319) -> fuvokrr, hqlyg, mozvs\n" +
                                                "vggsia (53)\n" +
                                                "ucbuez (14)\n" +
                                                "wixfh (5)\n" +
                                                "dgszhd (18)\n" +
                                                "joernlg (67)\n" +
                                                "elkflt (78)\n" +
                                                "lhvyfsb (37)\n" +
                                                "liymk (54)\n" +
                                                "xgitr (139) -> vhfwgvx, rqrtz\n" +
                                                "wxhsqe (9)\n" +
                                                "wssvxr (85)\n" +
                                                "bgmmb (17)\n" +
                                                "ehypcwy (334) -> xvlymgg, tgkbxa\n" +
                                                "qwbfod (68) -> ndpwgdy, knmac\n" +
                                                "nepxnu (6)\n" +
                                                "ftoskhn (34)\n" +
                                                "ponlfyf (82)\n" +
                                                "atkmjxg (162) -> xluwv, dinng\n" +
                                                "rrkqend (223) -> xaali, sxmdnhl\n" +
                                                "sbnsoxi (15)\n" +
                                                "fxemb (62)\n" +
                                                "sfyoyp (10)\n" +
                                                "lyhfj (79)\n" +
                                                "nnkmf (15)\n" +
                                                "xfmxo (73)\n" +
                                                "dilqo (84) -> ljvrcj, ognax\n" +
                                                "jxbksoh (157) -> xstrla, ykudi\n" +
                                                "fkhxkeg (26)\n" +
                                                "wsvir (36)\n" +
                                                "chetpy (363) -> ndcfy, ftdylco\n" +
                                                "iytknc (61)\n" +
                                                "hvifpbk (202) -> mhkxu, gfmgl\n" +
                                                "gyuyb (18)\n" +
                                                "whoqvq (55)\n" +
                                                "twtcx (524) -> htbjl, kszyl, hvapnf\n" +
                                                "wkxkv (81)\n" +
                                                "ainstbs (50)\n" +
                                                "ppfmc (35)\n" +
                                                "hvkhvwl (1351) -> hhrqz, kzcyjtb, javiioo\n" +
                                                "yeqnq (15)\n" +
                                                "aruczxj (31)\n" +
                                                "poinih (23)\n" +
                                                "kymbpe (745) -> ihmqs, uthjdye, nmxmtaa\n" +
                                                "kixaco (11)\n" +
                                                "oszlto (45)\n" +
                                                "ydmeqtl (34)\n" +
                                                "mojjl (34)\n" +
                                                "adxeaf (212) -> rdyda, vlagh\n" +
                                                "xjuoid (45)\n" +
                                                "rndomrv (87)\n" +
                                                "mhkxu (47)\n" +
                                                "znubct (69) -> dasyq, vlpqaxo\n" +
                                                "fdmbkt (50)\n" +
                                                "coaznz (84)\n" +
                                                "caxbgqp (23)\n" +
                                                "uhwvnbg (28)\n" +
                                                "orcyokv (92)\n" +
                                                "zgzsu (10)\n" +
                                                "xgwjcx (22) -> cfdpxpm, pmgwwzy, bscpyic, vmcgj, jaqwzi, spxwcuv\n" +
                                                "vpqqbz (94)\n" +
                                                "wvdapsm (65)\n" +
                                                "uapwikr (12)\n" +
                                                "olydb (50)\n" +
                                                "kjgtfqc (69) -> pdvolf, sgngx\n" +
                                                "cklpcr (58) -> hwjhf, foaayon\n" +
                                                "ottiad (63)\n" +
                                                "bjtza (250) -> caxbgqp, rpegyn\n" +
                                                "fdhdpw (18)\n" +
                                                "jqjkgv (50)\n" +
                                                "kguwwze (33)\n" +
                                                "blhgy (100) -> cwphzk, ceeem\n" +
                                                "aedcmjb (80)\n" +
                                                "drosj (98)\n" +
                                                "jbqvpsb (12)\n" +
                                                "isrch (7)\n" +
                                                "vzgsgk (10)\n" +
                                                "fjqomax (82)\n" +
                                                "twvdhg (55)\n" +
                                                "vvbcb (11)\n" +
                                                "yazsie (78) -> qscpjx, mxbyg\n" +
                                                "nkkgyl (166) -> kvmqsdx, znkzp, lyuys\n" +
                                                "mrizfl (108) -> ittmm, eyyokyd\n" +
                                                "fkkzg (145) -> vgsnxlm, bmltf, lircjh\n" +
                                                "zepvwyv (26)\n" +
                                                "idjhk (47)\n" +
                                                "hrtgwt (25)\n" +
                                                "iaixlte (717) -> surri, mkmci, rfmiqz, gyojd, rxcbsdp\n" +
                                                "ubxke (51)\n" +
                                                "imnvt (48)\n" +
                                                "hgmjvpp (35) -> wrpqf, uwpbnv\n" +
                                                "tiwakam (93)\n" +
                                                "rfwvc (10)\n" +
                                                "zjqeu (120) -> fuzhuf, opduu, ijictm\n" +
                                                "ymyzead (76)\n" +
                                                "veboyvy (61) -> qwjmobb, fmarl, hqxdyv, fhphiyb, cmmqbz, kqoigs\n" +
                                                "nwtlu (64)\n" +
                                                "rdghpyb (46)\n" +
                                                "srcyajr (77) -> vxjjxhz, aevhbim, sldytqh\n" +
                                                "hpltoci (199) -> qczhlyf, mfzvywf\n" +
                                                "sdbmop (35) -> vtkgj, jovkydi\n" +
                                                "nyejrrv (89)\n" +
                                                "negkd (266) -> zwoot, mpmue\n" +
                                                "ykudi (46)\n";
    @Test
    public void testPart1Example(){
        Day7 day = new Day7();
        assertEquals("tknk", day.part1Solution(EXAMPLE_INPUT));
    }

    @Test
    public void testPart1Problem(){
        Day7 day = new Day7();
        assertEquals("TODO", day.part1Solution(PROBLEM_INPUT));
    }
}
