package com.rox.adventofcode.y2020

private val inputSample = """
abc

a
b
c

ab
ac

a
a
a
a

b
""".trimIndent()

private val inputA = """
wdcmlzfnugqtvjbsahi
easrkmocxbpjgi

xrpnegqlcsyodhjfutzakmiwvb
mgilapxjtrndbheyqzckfouwsv

scynhfozmlvbqkarwj
qhvjkmbyxcfonlazdw
vjhzfnapwclkqiomyb

bpourq
ujpmoqs
obqup

v
v
v
v
v

hwjlda
thkdjo
mlhdjw
edyfjvh
djh

xvjadplfcwmkeriug
adgtscyjipewvulr

hmkipduz
mdzkupi

vtyizwcdm
zdvtcyiwm
mfzcywvtid
iydclntzvmw

ps
pm
pm
p
pm

nglatdiw
twialgd
igsadtwl
iadgtwl
igawltd

jqoxkavs
askoxvqj
aqjvxskho
javqkxso
kaxjoqsv

ltkjfoxes
aifogkepx
ufcekybmzx
tigxeahnkf

xzfqbsnhmrviju
rmfvsbihpujq
hstfumvgrobijq

bga
ye

sg
gs
sg
gs
sg

knipbjmtrqoawe
rtaebqkmopjiwn
ewbuqcaijonmrpk
trnmpeqkobjiwa

puifme
ufb
fvp
rntzlyxwokfcg

nufjzpyawbqsdgi
ogcmpsdqaxvnzwetklh

qmdxnfrjobatzwgcyse
rdxtqseawzobygcmfjn

dbot
dwetlp
odtr

utbqx
bxuqt
xtbqu
quxbit

rvthuiqbljzaofgwy
ldftrsjvwoiayzuekcg
dtxmalyuifznvprkcwgoj

twc
w
pwg

rmzaoylipcwkvuqesbhn
kpuvhqlwyrabmszecnoi
cwaylknbrhvzmiupseqo
qlwiyczkevsnarhbpumo

cgr
grch
cgsr
rgce

eso
ose
soe

swimuzq
zqwsmliu
iqzurwsmh
iswqzum
wzhumsqi

amolqcs
sqoayj
sjazqxyo
aqhxsot
ozsajqkx

qbkyhzfspewgrtlv
pyeqtcbskf
jxbsonqtaykpef
tqskfmyboeup
bdjtfqypokse

yrtwqacluozbg
vwtfgzmcqobraj
opctryzqawbg

v
v
v
nv

dclgejbqrwtkvsxfa
ovgkhjyiqwbmefc

vpkx
jmydw
fxa
xa

gwtocmzslfqk
olkgwzcftsmq
ogmsfzlwqckt

uwxdl
wdux
oxuwdt
dxwu

ab
smej
t

iwhlqdermv
menrvqd
jemdqvr

n
n
a
n

jqcvetapkbsyu
twndyfrixzhvmsogu

xsz
zxs
zxs
szx
sxz

fsatbzpvqjknlrm
pbnljkratfzvsmq
qtrasmjnlkfvbpz
bsjavlmpqktrnzf
qajlbkzvmtsnfrp

utlchvariswzqjmx
almujswrcthzvfqix

p
j
p
n

cgsxwk
uwkcxj
xpwethnkcyb

gywc
wcgy
ctyugw
gwcy
wgyc

afmtuw
muatfw

ujwmnirvkdygtqcabh
takwqdjgzcuivrhnom
cawvrnxfjmghdtkiuq

srgt
ma

urnymxabthi
rtxnailuqvoyph
duytknrwiehaxz
rhaumscngtyix

gawbhtkqruyjel
rlcqbuhawkmyfgjte
jhbyqgkraetwlou
gxbtrnadlejwhyquks
ujfkleagybrtwhq

dctkngohsxaljfrbvmey
mlbvxaksifyneodgjctrh
lmkfobtyxngsjvrdahec
srkyveohxfmcjdlbtnag
lbguestydkjxfopnvmhcar

pjrhgzdwcmxq
cgwhmqpjdrxz

meipjv
mivpje
jevmip
peimjv
vmpeji

zkcavufyr
fyzuarckv
fvnacqgksry
yvcrfak
crfvyka

pqynikfxd
dynxqlifpk

laozucfdek
kpeauocdlz
uoldfsekzac
dmekaclyhnuzo

hwubponvt
vwytnphobu
vpnbgtwuoh
wpouhvbtn

wcxlspod
fmedwbtjops
pwnoscid

ufenjp
ngfxpe
njbpfc
vqnthfazdp
pmfjng

qrphaykit
qkysrta
jbwdtqrxzav

wjqfz
jqfaz

meuxikpsdw
kjimpsdwxu
dmxpwikujs

fjbsnmcgxz
bpfimjnzduh

urtkjpo
cthod

voclmdguaw
oczdlntgmeir

zipf
fipz

nbwcexytjzripskmo
kwpzrmtxiosejcb
tsrcoebzpiwjmxk

jafcwtsukrodynhvqge
pubrlchazvetosyigqjdk

qminshlycutrdwx
vigzpqbmunacrjftokl

hweisfpycjdzouvmbnkq
nqjxscbvmuwhzfakdo

qtndfjcglrkoyux
jqtrlgfkducxnomy
tqnrjxckgfaupdoly

pbe
b

n
n
n
n
n

nsc
ns
nse

qzkxif
vkfqizx
kfzqix
zixkfq
ifzxkq

nvshwafe
vbewacnh
nvwmeah

ziafwxcnmebko
cdfrxmk
fkmpxc

y
y
y
y
y

yauxbwtcvgoq
ywcvotagxbqiu
gqwyvbacouxtn
uobqrcgwtvayx
qcgwoytbxuav

r
nr
a
r

xjrkwdnbyuscfgqtphiov
brshqnjcoukxitvywfdpg
vrxlptbcyfdwhgkouqijns

fqcvwudyiotjblzpxshgnmkrae
ouhrqwtgnjeyxiamfzpdscbkl

lnch
nhclmg
ldhzcny

uzfeomrwi
ydgkhjbx
qcylp

hagpbecorwyvfdz
rstplobhmfnxvykdewc
hfruowdvyjgbpzce

rgdiznuxa
dragzniue
jzysdgpuvkowqin
lugrndiz
nbdcfugzi

eqponlctfbwgk
kyjniulbegpdchtwoaq
onczetbplkwqg

thevzsrc
zcewrsv
vczueosky
wmzlcsve

sxeqojwkarhyutcdnzp
rjnuwzxpmeysdoctlaq
pzqxeratsdnkuovcwjy

qexjbo
cqunbaprhwyjfe
ilvegkbszdt
efbmqj

wm
wm
hm
wm
m

texosjaiycpqn
mntxspgikeldwycjarq
nysqtaceipjux
phiqznsyxjcvoabet
neqytxcuipsajvf

z
nozy

ydfcsvgbikjphamr
wskfdahgpvmrcjby
kpsirchfmjavbdgy
pslxjrugtzydaokemvbcfqh

t
pyt

fu
fu
d
yj
fnl

qxkevrhpna
kmvyorduqe

sfnmyevqwka
fvmyieawqks
kvfhmctdqjaslywe
ywfkvqeanms
kufwyqmaesvh

ulvtwepimynb
ehmpnylubtvwi
wplevtunmyib
lpbwnvtuyeim
unvpbgtjiaylmcwes

zfxkceynsu
xdfzysnuie
efzgxunsy
nzydesxfu

jneurlkfzxbq
xekznblfurqj
rbzljfkqnxeu
zueknrbxjfylq
xzferlbjqnku

tr
f
egtr
jmu
s

aeq
qae
eqa
aeq

bsgjrilayoezwndvtq
giadlcryjwobhznqesvft

guxfyzespj
zusejpfgxy
zxygjuefps

xvmlgpzjdrubqa
jfmbdvzeyrlup
ruzchykmbpwdvloj
vhmuebldrjzpo
bhvcmrypulzjiwds

cfsjzamyhtoxq
xoysjqfzmhtac
qocxatmfshjzy

vdhsifmynta
nsmfhdtya
tsnfhamdy
dafyqtsnmh

rfybkqmh
qoumrd

l
y
l
y
w

vlmerz
mlvrze
zvrmle
zelrvm
mzlrve

rnb
gdcb

pbtergc
tecfjgr

ogzsajwvdiplrtxbhfcnky
btjzlswhikyofgcpvrnda
tbwinagrhfyscvlejkdop
dakhrbipqglmovjyncswtf
bhyljrdpsktgfiancwov

qolmnyvhtwe
uwkecxshldmoy
zwblsockyumh
miywfgjhaopr

u
u
q

zdxynqmev
bdexmzyiqcn

bwtqagf
tnmwfaqbj

p
p
p
p
p

yjgicnxerbsu
xpzfqirsjh
exswmarikbj
mjxgrsi

tvzkbxugmcnshproiw
czxtirownbmpksuvgh
cnofirbgmhzuspvtxwk
gmctsrohkxwzupvbni
vsgbzcmktxihonwupr

dyaoim
aiom
ozimual
oxaim
biyotma

saliju
evzhxcobk
lj

txhebw
etwhbx
uhwxtbe

eyaixfrdhoqksc
eakiqsrocxyhd

vkr
kvr
kvr

surjoh
ubh
ubmahe
uh

vhkcawrno
vowahrnkc
oknarvwhc
cnkhvwoar
wvhkanrco

ntpfemsvialxgrwqzc
kcwegrtispxnyd
phstgwixebnucr
xpwjtenscoigr

sfanq
xgtzfrn
ulfinpkv

kdwnyjuzctiqpgf
ngtcrjipqfyh
ypfvcqntirgjh

urmtsh
svihtu
utmph
juthydwafcqx
uthve

sk
ks
sk

zxbvcrgyqfjtoeiudwpkhsm
igkswrpohqudcfjxzmvytb
cpatkzfuoyqgvrsmibhxjdw

kvgumiabnoh
bvaiomgnukhc
mkhnvusbagio
hamiobunkgv
umsgovkahbin

yrceuq
rmdbpa
nkvxjslwg

lkt
fl
vil

whn
hn
hn

gvebcszypdlkqm
zcyhdlpqgsvke
cdzbylqkpsuveg
pzsyxlgdaiofcqwvek
gmcpvyqzeskld

ryzfspdtbwxiomhkjnlu
tqihvployrmksbunzfwc

dualjxigyrzb
durysxjlgzaib
srgxulazbjyid
lrgaubjydzxi
azritbxdpljyg

cfahxspjelitdnobuvqywk
vwmkoxulnypfiatgjbhrcsq

f
f
f
f
f

grbmahpise
mbireyxhalgs

bcrkvuwqt
trubckq
rbuqtkc
trkbcuq
rubtqkc

zxpbejmvhrutwlkq
gtvrzphoqcbnmju
pjazbvqurgmysht
fhsptiumrvjqbz

kpszjieflb
blsijkefzp
zksjiefpbgl
ilbzrksajpfe
sglzbepfjik

nxwohsipd
zitjrlvfgsoym
bqsiopuc
aoisd

wj
j
fzpglynjeu
jk
ikj

abzftcqvgsrnexpmho
pxvlybndrtqimzhosacgef
nocqfzerjaubxthgmwspv

psauzryot
vmdhbwe
lfc
gsri
sqya

lkjudnqterhyscgx
eckqhlxybrngudstj
wotecvlyrpgqmijxkhsd

htpc
caph
hpustjc
nyhcedmgp

ezaljkfpiyvroud
hbiwxfstmldkecnvpgqo

kiqvzyjrthmblu
ahszlduemxcij

wirunkh
hwqdknyirul
kxwuhirn
hkirwnu
ierwunkh

vcgno
snmicvo
ncomjisv
coynuv
lconfdvpz

tgqkhowsyfbzpcur
zcqsugtwhrpfy
fgydqpcjswrlzeuth
thgpcfyzqeursw

rwpci
cipwr

ptrlaqebo
pebtlaqor
qboxepatr
epbartoq

fypd
dpyf
ypfd
fdpy

c
c
c
d
c

gxysqiamkpc
mpiacyqxkgs

mvqbskuzefy
zcsqebma
ztbnlhe

snx
xsn
nkxs
snx

joyblxztkswmvnec
gdcrhykmfseqapibzu

oqzmprikt
fhlgxucda

ygrjkfazu
kjiagrzyfu

btg
o
v
oc

bnqyz
ebdfls

vjhocqkamygbplu
dbwsyefuxzntijrc

kmlb
kqsbl

vhjsdxrfpokyznibwgtmu
syvkmzfjgpdwixrnbutoh
uzbjgvhdkpynmtfoxsrlwi
jpkxwvyrgftzioubhsmnd
ykjmzvsqnhxwgbrutoipdf

hwby
yvbmhl
echgiyabjpf
krbouyh
hrynotb

tobipzwfxy
pfxwytizob
hsfwzpbotiyax

znrgilpcfse
seinczlpgrf
nircgepszfl
rcegzsiflpn
lzgrcpensfi

tupvbxcgfnmh
fpqntvibgxhmc
npbtvxghfm
tvxfhmbnipg
rnvxmhfjgpbt

inysghdka
wbc

noktsjqvmzxheplrcfgiuwda
dlogmasfzwhupjrkcntixqev

zhwfbs
bzcwh

igqkpctmafr
jietalnfksqp

ewlanjvgdbpm
lpjangwvem
vpngjwmeal
glvwnpejam
enlgwjmvpa

niocufzwrk
kirmuzfocvw

juqervaxni
cudjqavnix
iuvjndcaxq
xvniqajugd
vxunjiaq

lmayozkep
koazylep
aeykzlop

ejgotzhrxbsnqimu
lrspkgobcaywmjfvhd

uazxfrony
uoaxynzrf
yunaorxfz

lowmgiuxpnakzsq
qwaomukglnx
ubgkoyqanwlvmx
lowaqgyxunkhm

alfoj
floj

yglkurfahidmoxtvz
muykfdrzivlothga
devylsarcupgoihkmftz
rmtgkalydnhvozubfi
ahrzqodkgxyuitvmfl

gmdoshlaixnc
xhmicdgosanl
hiqgvbulakdmoxcpn
hoiamdsngcxtl

egnprq
ash

oabx
abxfo

vomitazdbflqhkue
lvemipubdafohztkq
dkabtiylqgzuovehmf

euanfbq
skufxtami
nefauc

fadpbjxvzeghqkriy
xpaqfzjvybdhrkieg
jeqghzxrdyvakpfbwi
ygvakzbdpqrxjfeiht

dhvmgjoqzknbwyl
hvnlobmydwzqkjg
vbzljhdqgnmwoyk

s
k
sk
d

svzubcigpeqdthfmxnj
djogszbcnvefqthiuxmp

vgkpjwymduqfxcztoasne
swgapuymcvqnjodtkfzxe

stgv
yvbts
iokqv

h
h
h
ujxw

uz
uz
uz

cdh
lhg
mkh
quroafxhipsev

d
d
dg

lbrsefwhxagdmpqjiocuvyn
uobfgnhvsqwzlkjyraicdpm

uwnvthio

yudxpkhrngb
selctamwozqvf

ueiypcnoa
nidaehvt
akencir

ozcru
uoflar
pwoxuyvm

nrgaujbldiwxvq
sdvuirgaynbj

synqkzdlpebticorvwxmaug
ekyatuvbpohmxnfdgczirwql
ztvwupairdeqmckgbnylxo
alngerwtckpvmioxbduzyq

dqygzrkuowejsm
zyikwtjsver
yzjrsvawceik

lqduw
iudw
wdrue

zxnrflac
lx
lvx
otlwkx
wxyl

q
q
q
q
q

aigmyqxscvhde
csegmkqdnvyahix
gvqixcdheysam
dsmyaexgivqhc
shiqmxgdeycva

nbmovulhpai
yfcobuiaetpdvmln
mnopuvlbia
wviopnmluabk
uvamohipklnb

cibznrjtsgoafdlkx
cethszlarinx
xcsztairehnlp
szhnatlxicr
mpselnxatyzric

qxdzauyvbc
qxzvabdcuy
zyxabucqsdv

uzxvatmprofyjcliwgbdsqnek
kynesjvmoifucbpqwxlzrdtga

mepouwaj
cutjoxvpa
apojcvftd
opwdaj
njhzgqrikyapslo

efqisyl
elfqsiy
sfiqley

if
wvzghe
xn
dnxu

afuolgsxdckypbenqjhmr
euqojgbfzphxmnrysda
xsbwrdmnfqyphaegjuo
xsfuhpgnbjmwqoaeryd

xjyizvdsbkfmhenwop
mueiojtyqnag

bjlvkzugwqspcihmxr
mlugrxwjqsvibczhkp
vikuscpzwqhmgjxrbl
pxzbksqmjlcgihurvw

payfmlnhgtzsrxke
yeknlfshmrgztx

p
p
p
p

gnmcwdtquesz
ztdscnkg
zdancosjgt
cdntzsg
zcjgbpstrnd

ugxawjehznr
gujxqzrwhnea
rewagunjzhx

krvmqtuiwsezbjcdhployaxngf
xkwsubhjlfvparcgomyenidzqt

jrglbkzcwtuayno
iwydqmzt
tdwfeyz

jnvchaxzotqd
jdaohpexnt

yifrdlua
asridu

rchuily
brliyc
icyl
nclfjxiytvs
hiycrl

fj
fj
jf
jf

hncwvidj
ncijh
qjhrin
zsxiheynj
jvihaqnc

zkraj
zkjrl
akjzr
zsvjrk

culpozwn
copkslvruwt
fhwlecupo

cuibdzoagynvrkw
dobjkzuxvrcyinag
ipsduzkvybnoacrmeqg

gjwfeblzasoirpvhcqtxu
dcfqurpiaxslgjhbyzwmeno

agi
sa
vuhaksj
zatyex

xponks
ojnkpsx

cqeiyuforpx
bxfnzrs
xhfnvdr
rfx

tqowdj
dw
diwfu
dfewgi
wd

dyvjwabnuzgx
bjdyglxvzonw
dxbwnyvagjz
zyiwdcgrbjexvn
xjngvztwbdy

ob
ob
bo
ob

cp
cp
cg

cnwlshdkyboxmpvtz
ndswvmyzjeuprbgchl
ayzkbswhlnfptcvdqm

cmfyketonuixwdgpav
xeyngtvuwfcdik
xdufiwcnekvtgy
zuvyixgbsdhwnjkelcf
xwdfvucyinekgr

vwznkidlhxuaosfr
rhakozvwgfisdunl
korahvzwdsyilnuf
fhniwvurokxszald

rlhewm
whpr
wraqfh

szpvechrdnybfjmog
vgptfyjmbdcxzshe
zhsfqepvtygnbjmdc
yzhjalgcusdpfbmveik

xapwbucizkl
qgs
yoehs
jrsge
vjgdtm

vxyuftcbpl
uycftxlbpv
vtxflpbycu
pbcxfvtlyu
xylavcftupb

yhbadxqs
hqdxsay
zphxtaqsd
asdoeqxhfnj

tlmrid
osmrjwlvge

hfprkgzljcs
slghpczfjrk
flcjzshpgrk
hzfcjsgklpr
rgphlfjkzcs

jizfvmyocxq
kogmzyjiqv
ujnqwpaszvhymro
gxomvzjcqy

ie
ie
piec
ei

tvaxzm
txamv

puqcatmbe
bcuqto
ubsiqhzgc

vkqogu
oqfhigvudm
voqubg

zlfapsjxtm
umalzjpfosxt
jplsftaxzm
tafzxlpqsbjm

zicyojr
ilzcyr
hzcrtleyvipf
zicypr
yicezur

ehigkrowmvjylnxb
tihkwoxbjelnmrvy
nkjbmxwhoelrviy
vnojlkwxrmhbeiy
lvkhxnowmjeyrib

bpzgcrtoisywvned
acdwbrytesguv

b
qb
ba
bh
b

hntmvbilk
tnmbzvl
vbfnmt
yvnomuxbtw

ib
ib
lib

jefqbsd
iyhzrvcngl

zaeqfuhynlbxipwvgotkd
kagozfcnbirmpuesywdv

wfulhibnvtapkyrq
ibleqfykavprunmxwth
raulpqfwbhvintyk
vnwrklhufytbapiq
bknqpvrytfuhlwai

wtgqajfmk
mwbfcjukqga
fmghkjwaq
gfawqmjk
fjwmkgaq

lxk
t
w
w
mf

mnzbcw
rad
ejpxykvhu
zslo

fatkelbspwjyhoqrdui
qsngucrzamvx

ldwhapn
wnma
awn
wnau
naw

fnrgykvulp
vyrlupngk
kynprgualvq

oz
oz
oz
zo

dehqmlkfyxpvujagbtcwio
huapickwemyblxodftjvgq
pagblyvnjotwekuhcfxiqm
qjythibopgxaeckmwvluf

huclkitbnrad
uhdoictnrklba
tlcbauhdinrk

pamdyrxtj
pktnmarybxjd

tr
drt
rkt
tor
rt

gjrclwxyuk
isqmdbf
eoivmdfpt

qvg
i
ui

j
l
u
lu
osd

zmdknlf
nzlfmdk
dmznfkl
dzlnkfm

ozdievpxm
mzoxdiepv
idpzexovm
ovdemzxpi

cbyrndpwk
kozyrncdp
ujcksndxphyf
dnbpkyc

e
e
e
w

tpndq
igpajc

gihvnzfacujpoelxqkr
mqfjnrodzkuvxaipel
okwanixqlpjufevr
rxipfjtasnekyulqvob

jmgeixvhaoknq
qloihgekvjxman
ajoghikvmpxnqe
ingovjkaehqmx

szualfd
zsulfaw

osajgkmyfvri
hwmisgbaqf

bvzm
izwrn
zsfd
mz

kixhabnoqpzsg
gpnxaikqobzsh
argcboiqznkxsph
oaqgicsndhkbzxp
jzxhpstoinqbkga

fkisv
fvisdrk
vkmisf
ksifqv
ifspvk

ovwqbshjirpg
iohbgfjqcrvt

efsqtnoywmkzrv
gwsotczmkdyqlrve
zmverktswfynqo

rwtuihvjqofszxaykn
riqntxydpcakjbgo

mzkndrhabvj
gywofampnlxbhsi
hbtenma
rcamubhn
bmndhkja

afsnkue
pfcvirzydqbetlk

zftwoivcr
rtvzwix
kzjwtrgi
hitwzor

harkxeinjtgpy
tprbwighzeksymcv

qecrsugzdho
uwdxocqyftnbzhl
dcrzqhuso
sdchqozu

cu
u
u
u

whlfczpqa
yfzhpqc
zpfobxkhqc
cfzhqp
fcozqhp

erbnkjqouhg
qsthnrjiwxvzkaf
yncqejdukrh
klqubphrnj

ikvyfmlpacez
mzeiplkacvfy
lyfzipvcmeqak

qo
h

neuzqjk
ixqhknj
pvbrygdacs

xf
ef
f
f

t
t

j
z
ybx
a

ewbmvucapsxkig
ksiprxbvagwfme
agdmiwexvsbpk
egisawxkpmbv

dykmbtv
dtjkmyv
mvkdtyc
ydkmtv

zw
o
i
oi
r

hjybnqczotxgeiaup
cpygejxuzhonitqab
jnauyiohtcepqbzgx
uaqtnyicgezoxjpbh
nptbcijxzuoeayqgh

owynpg
wpyn
pnwy
ywpn

fqoishlxzarmkc
dstzjmxrvfckuoi
xsmozrfcik
zmgsrcwiofxpku
igrkebsfoxcmdz

moas
xdcfmoa

xltpwzrf
erbhflxwzntp
tnsrbxlawpzf
rtzwuoxipfl

yesonitqag
etigoaqmynshc
tpneigasoqy

pnmvfgwyierqukct
tcnuigmqpeyrwvk

qza
zaqr
zqa
qza
qza

dyphutng
ghntydup
thpudywng
tpudyhgn

gofac
homgpwae
govmnaw
azsgo
apgmyuo

bsvqmnidyogzuewtk
qitsokmnewdbuy
iqskwxyonmuetdb
kbmsundoywiqte

uoqj
jvs
yjazt
j

r
o
nv
oy
r

u
ru

avofjnwdehrpyklqugzimtx
gfjlwkrahzqvneodmutpyxi
mgpjlfuxoyvzwqtdhaeknir
ryfqedjgpnikawmtxhvuloz
gidrokyntxavfwpmqelhzujc

k
mzp

jfpow
jfop
pfjo

qokte
eno
woef

qnart
utaqr

ajqivchfpem
upvqhcjmafe
pvewjfhmcqa
vmjpecaqhf
cahpfemjvq

ayw
kp

rixwjogsfhuyvebnp
vexwuhjyogrfisnbp
psyfwhrxeogjubnvi
yjvswhnrogixbufpe

eylbtgqvronjfzphw
brhqvoptnjeygwflz
rwhlpzbgjvoneyqtf
hcvlnbegyrfwtpozjq
ynwefqphlvrotbjzg

xyu
xy

bj
j
j
j

kocgiwr
ibksgowc
ijkcwog
wiegjcaok

rlt
ltr
lrt
rlt
lrt

xjoc
jcoxz
cxjo

r
r
amrtqgfw
udr
sderl

vonauts
atxsyvco
psroawlevbjdgk
smvzhqoya

ubwotjecsqhadvkf
ufqkjtesadhvcbow

pbqsuatrzk
rsquzpobk
pqsrbzkdu
zqcusrkpvb
spbkqrzu

vqwcinpb
aiejfduvpht
zowvpinrxqml

zufk
kwe
k
mk
wko

lydtzkhwajf
xrphuebsogm
nsucmhgqpx

mwhlnfotz
shvfwmanl

xfywodzc
fyoxchw
howycfx
owyhfxc
xwocyf

hri
rv
lzr
r
nrfc

mkd
yvjkoguaxip
nwkz
bcktdsmqf
sznkw

flhbygto
ftbylhoa
otbyflh
yhbtfol

rnphowmiy
hpwrmoyis
iunworypmh
diyrwhnmpo

qlhfdcg
plju
rl
nalk
lep

xwcropjbzkdegnufsqiht
rcidlowgxnsktqpbheyzfju
ctfxzgvprnhbqeodkwjisu

wgzu
fkbuxrwg
gwjyuhzn
nhjyzuwg

rwbm
wmkrs

itzekynp
dkepiunyt
vmwlbgkcipnseqr

xlkbgo
kgz
kag

i
x
htq
sot
f

kuqperwixsgvbctyjfdn
qjcdstpxvyuwifnbre
atqumpwrefdxvoijcznys
rfxdcuispnewjtkyqv

imdwuntbahxvj
daniwhemzxtjb
nhmajglidtxvwb
tbjinhxwymad
csaqnhdtfrmjobwkix

esjkcgpf
gmfszpk
pfgksj

i
i
i
i

alnj
zucmhenrtoq
bkn
nifp
nvi

mjkagdfsilctvpwhuq
wufhtjlgpaivcqdsmk
qutsghdvkmcwfaijlp
vutlpwschfkamqjdgi
isjwtmqkvfgalupcdh

ynsgxmfoelkd
yxmvgkd
vgmykxd
gmyhkdx
ygxmkdz

vldyroebks
osverdjlyb
eszyrudvblo
rvdqomlcbtygse
oredlbvsy

o
o
o
o
jvmo

jbkpwnc
dtwrpiqbsf
vlayehgxmozu

khc
crkylh
ewticaxphkd
fhncmk
khcf

ofvtnbpayduik
ufbiatxvpdoyn
oibfupdrtvyna
favdotpyixuqnb
ywatimcefbgvpsoundz

ismcgzfqbxdlv
zlwdsivqcbgmf
szcbqidfgvlm

fgjx
xjf
fxpjm
xjf

etuipyaxvmjszkf
aeyjvuwzspkim
pajvmizekyus

nmbyxzehsagcdfjvt
hzbaxdfyjevntgc
dvthajbznegxfcy

ftwqrgzohp
hexzqdjsrfwmu

eubmrcntqyxpsjozvilgadhkfw
zjfrdtwiuyoaepcnmkslqvgxbh
keiurfhgmzovydqapcxjswntbl
umkocxlwagfbzepjyirtvdsnhq
kngzxjrshovmdbtclwfiqepyua

lyomqhdu
mylowqh

chlwr
rhwcl
crlhw
wcplrfh

tamkofzcpq
tomgsjqca

bj
vfwbi
gb
gbz

njaecfkliuwm
cnvkfwualmij
iaunwmfelckj
hjifcqxumnkalw

iht
orlie
afsxupiz

nocfkzrdstjqwu
ehisrtpqnwgaymbuc

qxgt
gtoxcj
txgr

hoxsgkdiqtfz
gtfisxozhvdk
gofksdtxihz
izghftsdokx

i
x
a
i
i

knqftuisvegdjw
ymogrc
yacpbrog
gxlp

sa
k
k
w
b

speodbqvngkjrl
nfslobmegdpkjvqr
rpgbneasdkljqvo
dnvklcgjiorqpubse

y
y
y
y
y

pahzx
axpz
axzp

ya
a
ay
ta

haposzk
lromwgtifpz
xobjpszq
pujonz
ndopyqvz

wqfl
kwuqelft
lfbvwq

cqgefyksvhwpalxdbrimoznu
spvyfeucqnigwxbkzrmadl
sxlwrdbyvgzpqmnuacfejti

ou
uo
uo
ou
uo

oridzvksnfuep
vsrpfexizdoq

nxo
qgx

xybutqfszdhl
ybsdlqfxutz
zlxuydqbtsf

tl
tbla
rtel
jtgxlohyc

w
vrgofi
kcjt

xkqnrf
pxqnr
xrqn
qrxnp
qxrn

pabnotufrs
bornptsda
sptobanru
mjzonarsplybgt
uranspoqbtx

gncfptk
qyodies

tiln
lt
lt
lt

ecbxuofajgshqk
crehbqksaoifjux
klibxfuhqejocaws
csbxhojuatefkq
gjaqcexhkofbus

egjflivrcywdtu
gyiedbfovxt
qsviadhygtef
gihexypfdvnt

niotdwkarb
jbimonfkl

j
z

yfob
bymsrul
byqu

dsycgzhtioxrpwvlen
edskiwvnhozrcypglt

ygcjblprwkiehz
esfjghqbliczwpuk
ieghcjlpzkwmb

mcephzsxawni
imazphsnexw
mxezwnhysipa
wsheabqmnipxzd
pcmwhysneazxi

yovtlfcuiwxmskzjqeghr
gbcvlityzjxqmfoswkue
mqlgfwkvysjuzntieoxc

hivam
amfuvi
aemv
mxahvg

lze
le
lze
lepd

jwpm
wjmc
gcmjw
mjdaw
jwm

s
sxuq
su
ns
uqs

csqmipzdnhxkvfgt
hxdfqvptigsmcn
snhpfmtgqivcxd
scihxqwpmdntfvg

nrsmoa
rsnma
sramn
nasmr
msnar

yihjeplactzrdfb
ztfekaljidry

qwhty
gweh
zksdnuipmhal
oxtwrhcbjq
qhcvb

ybemxa
jseoixkvc
ugdxepl

tofhpsgaul
lqushgofp
lfphogsu
goplhsuf
lhsugpof

gdwzk
xqw

wmiagjvocxrzkhdtfu
xhwscvljdqryibpgofma

rgacswftbpxydum
rsmtxdypgofuacwb
rwqkufstdjxmnalgbpyc
thzabcdwprgyxmsfu
caywrpsduftgxbvm

dujpzvsb
jusdvpabr
odvjbsup
budpvjs
kpujbsvd

gfpncwmjrdlx
rwmcfnbdplgj

djw
jdw
wjd
diwvjn
jwdb

h
k
z
k
v

al
lpa
la

chinjymkwe
vnwgcemkp
kvcemyxnj
enkcm
krlceuqnfom

glewafm
ngqawfvul

fia
rup
j
rmp
ju

dgvtfbxow
wvtjgbdxf
gxtbwvd
tbndgxzqvw

kuycgeanqwh
unkhyceqgaw
aykcweqguhn
ceqhwkunyag

vcighoudqlamkrt
dnyhemguilvqtao
hxzoubfvgiqajtlwm
ovqepnmgladtihu
oatnlremuvsigqh

nd
wdn
xnea
ribpvsfynoctmqh
n

rpflnskacoq
laqojrp
liprwqao
aojlprq
oarqipl

jvk
zwmvj
jv
vj

vydxlwk
vxywd
xdyzurw

lqghripoewbjdvy
qbpcdjlwhovrey
pledvrqbwhsojanf
hjqdbptlmwzeogvr
rqjwohdipuvble

h
h

ot
t
t

fyxkdhnwalez
weakhydnlxzf

xhqawsrol
guxblwar
lvkjrydiwxmptea
wfaxnrgl

famd
xmd
md
fmd
damj

istm
smbj
mwbs
msw
ms

raszvfpwdmeich
awfmvlizcperdh
pjviuhacmzfwdryqe

t
t
t
t
t

b
b

uemjsklzft
teukljfmzs
ztfjulsemk
jkfesztmlu
jlumszeftk

toczuxmkslrhpvijeg
mopultekcxzv
xukmoedpltczva
kpolveuzxmtc
pktdovemcxzul

agvfm
jvogqfiau
vdaogf

c
gqd

sgfpy
sgfbpl

jretxvqmfghp
tureqgfvjm
ijtyqezrgvnfml
mergqtjfv

ubzsrptcgxwdoe
tebrzfpwuxgds
wbdrxtfpgsuez
gvnuhzpdebwaxtrs

gdqmje
gqtcpdmfe
rxqyiehnogmsbdv

fqwzlinbormheg
mjorlniezb

ia
ai
ia
ai

xghswfuabdlqicnyekmt
bgetcxwalnkdiysfuh
sigwankrfuhtcxedlby
nlwxfucbhgtdseikya
khawdecfngultbyixs

cwzgvbuqlsyetoiajnpm
asjpbudkhoinqgtzryfwevxc

zbpfxictqy
udpyqtxizcgef
zptxicfhqy
hpqcfbzixyt
zxhqpyftic

oirypkjhxfcwdqeagu
hwoqyupdrjigbmvxsa
kxdhpangqieuroyjw

fegnzr
rzfgne
erfnzg
znfreg

pvuafthmr
dvpmwcyg
""".trimIndent()

fun main() {
    println("Part A: ${solutionA(inputA)}")
    println("Part B: ${solutionB(inputA)}")
}

/**
 * --- Day 6: Custom Customs ---
 * As your flight approaches the regional airport where you'll switch
 * to a much larger plane, customs declaration forms are distributed
 * to the passengers.
 *
 * The form asks a series of 26 yes-or-no questions marked a through z.
 * All you need to do is identify the questions for which anyone in
 * your group answers "yes". Since your group is just you, this doesn't
 * take very long.
 *
 * However, the person sitting next to you seems to be experiencing a
 * language barrier and asks if you can help. For each of the people
 * in their group, you write down the questions for which they answer
 * "yes", one per line. For example:
 *
 * abcx
 * abcy
 * abcz
 * In this group, there are 6 questions to which anyone answered
 * "yes": a, b, c, x, y, and z. (Duplicate answers to the same question
 * don't count extra; each question counts at most once.)
 *
 * Another group asks for your help, then another, and eventually you've
 * collected answers from every group on the plane (your puzzle input).
 * Each group's answers are separated by a blank line, and within each
 * group, each person's answers are on a single line. For example:
 *
 * abc
 *
 * a
 * b
 * c
 *
 * ab
 * ac
 *
 * a
 * a
 * a
 * a
 *
 * b
 * This list represents answers from five groups:
 *
 * The first group contains one person who answered "yes" to 3
 * questions: a, b, and c.
 * The second group contains three people; combined, they answered
 * "yes" to 3 questions: a, b, and c.
 * The third group contains two people; combined, they answered
 * "yes" to 3 questions: a, b, and c.
 * The fourth group contains four people; combined, they answered
 * "yes" to only 1 question, a.
 * The last group contains one person who answered "yes" to only
 * 1 question, b.
 * In this example, the sum of these counts is
 * 3 + 3 + 3 + 1 + 1 = 11.
 *
 * For each group, count the number of questions to which anyone
 * answered "yes". What is the sum of those counts?
 *
 * Answer: 6504
 */
private fun solutionA(input: String): Any {
    input.split('\n')

    val rowIterator = input.split('\n').iterator()
    var sum = 0
    while (rowIterator.hasNext()) {
        val groupLines = combineGroupLines(rowIterator).first
        val count = groupLines.toList().distinct().size
        sum+=count
    }

    return sum
}

/**
 * --- Part Two ---
 * As you finish the last group's customs declaration, you notice
 * that you misread one word in the instructions:
 *
 * You don't need to identify the questions to which anyone answered
 * "yes"; you need to identify the questions to which everyone
 * answered "yes"!
 *
 * Using the same example as above:
 *
 * abc
 *
 * a
 * b
 * c
 *
 * ab
 * ac
 *
 * a
 * a
 * a
 * a
 *
 * b
 * This list represents answers from five groups:
 *
 * In the first group, everyone (all 1 person) answered "yes" to 3
 * questions: a, b, and c.
 * In the second group, there is no question to which everyone answered
 * "yes".
 * In the third group, everyone answered yes to only 1 question,
 * a.Since some people did not answer "yes" to b or c, they don't count.
 * In the fourth group, everyone answered yes to only 1 question, a.
 * In the fifth group, everyone (all 1 person) answered "yes" to 1
 * question, b.
 * In this example, the sum of these counts is 3 + 0 + 1 + 1 + 1 = 6.
 *
 * For each group, count the number of questions to which everyone
 * answered "yes". What is the sum of those counts?
 *
 * Answer: 3351
 */
private fun solutionB(input: String): Any {
    input.split('\n')

    val rowIterator = input.split('\n').iterator()
    var sum = 0
    var lineCount = 0
    while (rowIterator.hasNext()) {
        val groupLines = combineGroupLines(rowIterator)

        val alternativeCount = groupLines.first
                .toList()
                .distinct()
                .map {a ->
                    Pair(a, groupLines.first
                        .filter { c -> c == a }
                        .count())
                }
                .filter { e -> e.second == groupLines.second }.size

        var count = 0
        for (letter in groupLines.first
                .toCharArray()
                .distinct()){
            if (groupLines.first
                            .toList()
                            .filter { it == letter }
                            .count() == groupLines.second){
                count++
            }
        }

        //Both methods of counting, written separately come to the same number...there's a flaw in my logic
        if (alternativeCount!=count)
            println("Huh?")

        sum+=count
        lineCount++
    }

    return sum
}

/**
 * Combine all contiguous lines, stopping at an empty line and combine into one passport entry
 */
private fun combineGroupLines(iterator: Iterator<String>): Pair<String, Int> {
    var nextLine = iterator.next().trim()
    var groupAnswers = nextLine
    var count = 0
    while (iterator.hasNext() && nextLine.isNotBlank()){
        nextLine = iterator.next().trim()
        groupAnswers += "$nextLine"
        count++
    }
    count = if (!iterator.hasNext()) count + 1 else count
    return Pair(groupAnswers, count)
}


