# Esercizio di risoluzione di un merge conflict

**Il tempo massimo in laboratorio per questo esercizio è di _20 minuti_.
Se superato, sospendere l'esercizio e riprenderlo per ultimo!**

Si visiti https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test.
Questo repository contiene due branch: `master` e `feature`

Per ognuna delle seguenti istruzioni, si annoti l'output ottenuto.
Prima di eseguire ogni operazione sul worktree o sul repository,
si verifichi lo stato del repository con `git status`.

1. Si cloni localmente il repository
 git clone https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test remotes_merge_conflict
Cloning into 'remotes_merge_conflict'...
remote: Enumerating objects: 12, done.
remote: Counting objects: 100% (4/4), done.
remote: Compressing objects: 100% (3/3), done.
remote: Total 12 (delta 1), reused 1 (delta 1), pack-reused 8
Receiving objects: 100% (12/12), done.
Resolving deltas: 100% (2/2), done.

 git status
On branch master
Your branch is up to date with 'origin/master'.

nothing to commit, working tree clean

2. Ci si assicuri di avere localmente entrambi i branch remoti
 git branch -v
* master 8e0f29c Change HelloWorld to print the number of available processors

 git checkout -b feature origin/feature
Switched to a new branch 'feature'
branch 'feature' set up to track 'origin/feature'.

 git branch -v
* feature bed943f Print author information
  master  8e0f29c Change HelloWorld to print the number of available processors

3. Si faccia il merge di `feature` dentro `master`, ossia: si posizioni la `HEAD` su `master`
   e da qui si esegua il merge di `feature`
 git status
On branch feature
Your branch is up to date with 'origin/feature'.

nothing to commit, working tree clean

 git checkout master
Switched to branch 'master'
Your branch is up to date with 'origin/master'.
 git status
On branch master
Your branch is up to date with 'origin/master'.

nothing to commit, working tree clean

 git merge feature
Auto-merging HelloWorld.java
CONFLICT (content): Merge conflict in HelloWorld.java
Automatic merge failed; fix conflicts and then commit the result.



4. Si noti che viene generato un **merge conflict**!
5. Si risolva il merge conflict come segue:
   - Il programma Java risultante deve stampare sia il numero di processori disponibili
     (funzionalità presente su `master`)
     che il nome dell'autore del file
     (funzionalità presente su `feature`)
 cat HelloWorld.java
public final class HelloWorld {

        private static final String AUTHOR = "Danilo Pianini";

        public static void main(final String[] args) {
                System.out.println("This program has been realised by " + AUTHOR);
                System.out.println("This program is running in a PC with " + procNumber() + " logic processors!");
        }

        public static int procNumber() {
                return Runtime.getRuntime().availableProcessors();
        }

}
 javac HelloWorld.java
 java HelloWorld
This program has been realised by Danilo Pianini
This program is running in a PC with 12 logic processors!
 git add HelloWorld.java
 git commit -m "merge conflict solved"
[master 9ca7393] merge conflict solved
 git log --oneline --all --graph
*   9ca7393 (HEAD -> master) merge conflict solved
|\
| * bed943f (origin/feature, feature) Print author information
* | 8e0f29c (origin/master, origin/HEAD) Change HelloWorld to print the number of available processors
|/
* d956df6 Create .gitignore
* 700ee0b Create HelloWorld

6. Si crei un nuovo repository nel proprio github personale
7. Si aggiunga il nuovo repository creato come **remote** e si elenchino i remote
 git remote add shadow https://github.com/Icobart/61_merge.git

 git remote -v
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (fetch)
origin  https://github.com/APICe-at-DISI/OOP-git-merge-conflict-test (push)
shadow  https://github.com/Icobart/61_merge.git (fetch)
shadow  https://github.com/Icobart/61_merge.git (push)

8. Si faccia push del branch `master` sul proprio repository
 git push shadow master
Enumerating objects: 15, done.
Counting objects: 100% (15/15), done.
Delta compression using up to 12 threads
Compressing objects: 100% (11/11), done.
Writing objects: 100% (15/15), 1.55 KiB | 1.55 MiB/s, done.
Total 15 (delta 4), reused 10 (delta 2), pack-reused 0
remote: Resolving deltas: 100% (4/4), done.
To https://github.com/Icobart/61_merge.git
 * [new branch]      master -> master

9. Si setti il branch remoto `master` del nuovo repository come *upstream* per il proprio branch `master` locale
 git branch --set-upstream-to=shadow/master
branch 'master' set up to track 'shadow/master'.

 git status
On branch master
Your branch is up to date with 'shadow/master'.

nothing to commit, working tree clean
