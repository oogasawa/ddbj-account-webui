
# フォームの設計

とりあえず現行のスパコンのフォームをPDFとして保存した。

# スパコンのホーム領域が各ユーザーに２個ずつ出来てしまうことについて

## 課題定義

スパコンユーザー登録時にホーム領域の大きさを何らかの形で指定するが、
いままではPhase 1, Phase 2があったので絶対に2個必要だったが、
次期スパコンでは一つにしてしまった方がいいのではないか？

## 考察（途中）

---

同一責任者が複数のグループを持ち、
グループAが40TB、グループBが50TB、グループCが1TB使っていたとする。

グループごとに課金するとすると40TB分 + 50TB分の課金となる。
責任者がグループをたくさん作ることにより、課金を逃れることが出来るのは自明。
=> 従って同一責任者の合計は91TBであるから、グループがいくつあっても91TBで請求する。

同一グループに、助教の先生が10人居たとすると、それによってグループをたくさんに分けることが出来、課金を逃れることが出来る...? 。<= だから、グループを統合する作業はやらないこと。

ユーザー 1,2,3,4,5
これらがグループ1を作り50TBだったとする。
ユーザー1,2,がグループ1,2を25TBずつ作ったとする。（課金対象外）
ここにユーザーが1,2,3,4,5それぞれ作ったとすると課金対象外で25TB x2 = 50TB使えたことになる。

これを防ぐ課金方法を考える。
グループをつなげる作業をしなかったとしても、ユーザー1がグループ1,2に属したら、このユーザー1が使えるストレージ総量は50TBです。だから、このユーザーの責任者は課金対象だ、となる。（ややこしい)


単純には責任者にストレージ容量を振りなさい、残りの人は責任者にぶら下がりなさい、か。
責任者は複数のグループを作っても良い。総和が支払額。
問題は、責任者が寄り集まって、ストレージを融通し合うことで、課金逃れをすること。
グループを統合しないのは当然として、
グループを統合しなくても事実上使えてしまうケースが発生します。
単純に教授、助教授が20TB申請し、実質使うユーザーは学生１人で、両方のグループに属する場合。

これに課金するかどうかだな。ユーザーでつながってるやろって。


一方、実質使うユーザーが民間企業の場合... 違うアカウントで申請するからデータのコピーは出来ない。
(scpで2アカウントあれば出来る <= この場合、ファイルが２重に置かれることになるから、ストレージ使用量が増える。だから別にいいわけだ。）



学生の場合、同一アカウントで両グループが使えるので、ファイルを２重に置く必要は無く、そうすると課金逃れが成立する。<= 課金すべきやね。






A => B(責任者) => C(責任者)
Cがグループ1,2,をもち、Bはグループ1に属す、



ストレージがphase1由来phase2由来に分かれているとめんどくさくてしょうが無い
しかし一方で、ストレージの調達を2期に分けておかないとデータ転送が出来ない、システムが止まる。
これをかいくぐる方法を考えておかないと、そもそもグループ分けが出来ない。

個人ゲノム => lustre 6
phase 1,2 => lustre 7,8



次はlustre 6が無くなって、次のストレージが入る。

個人ゲノム => lustre 6 => lustre 9
                      => 新ストレージlustre 10 (空)
phase 1,2 => lustre 7,8  => lustre 7,8


コピーする

個人ゲノム => lustre 6 => lustre 9
                      => 新ストレージlustre 10 
phase 1,2  => lustre 7,8  => lustre 7,8 => x 撤去

その次のシステム

個人ゲノム => lustre 6 => lustre 9
                      => ストレージlustre 10  => x撤去
新ストレージ lustre 11


つまり、交互にするためにファイルシステムを分ける必要は無い。


一方、運用途中でlustreのバージョンを上げるためにはファイルシステムを分ける必要が生ずる。
lustre FSは3つ必要。





