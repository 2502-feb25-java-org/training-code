# training-code
This is a java training repo, used for code base, projects, notes.

## Environment Setup
** [github](https://github.com)
* Create an account
  * We will use this for version control, class examples, and submission of your assignments
  
### Useful Links
* [Git Cheat Sheet](https://services.github.com/on-demand/downloads/github-git-cheat-sheet.pdf)
* [Git Basics](https://youtu.be/0fKg7e37bQE)
* [Git Team Basics](https://youtu.be/oFYyTZwMyAg)

*The most common laptops are Windows PCs. Where MacOS and Linux systems can use package managers, Windows prefers its own GUI wizards. The following guide attempts to introduce Windows users to the command-line without requiring virtual machines, Windows Subsystem for Linux, or Git-Bash.*

## Windows Package Management
Chocolatey, Scoop, Nuget, and many more package management tools are now available on Windows. We will start with [Scoop](https://mikateach.com/a-better-way-to-install-application-on-windows/) for its simplicity.

-First, open PowerShell (Right click on Start) and enter:
>Set-ExecutionPolicy RemoteSigned -scope CurrentUser

-This allows downloaded or local scripts to run. Confirm all changes and then enter:
>iex (new-object net.webclient).downloadstring('https://get.scoop.sh')

Scoop will be installed to the $HOME directory (`C:/Users/{$USER}`). All apps installed through scoop can be found in `$HOME\scoop\apps` from now on. Scoop will also set environment variables where needed, and does not require an elevated Administrator PowerShell session.
#github

To add useful repositories, enter:
```
scoop install 7zip git
scoop bucket add java
scoop bucket add extras
scoop install vscode ojdkbuild8 maven eclipse-jee
```
This sets you up for Week 1 and 2 for Java batch. Even if you have older versions of Java or only a JRE, it will 
update JAVA_HOME accordingly, as well as give them mvn, and plops Eclipse into Start Menu.

* [Slack](https://slack.com)
  * www.slack.com
  * Create a slack account.
  * We will use this for communications between the group outside of work hours. Hell, even during.
* [Hacker Rank](https://www.hackerrank.com/)
  * Good source of practice. Use it often for practice. Of course, if you still have assigned work to do, that work takes precedence.
* [learn about md files](https://guides.github.com/features/mastering-markdown/)
  * it's always good to read and manage markdowns.
  
#Scoop and git commands:
- pwd
- ls, dir, tree \fast
- mkdir 'folder'
- install touch 
- sccop touch index.html
- git clone 'url' (choose the folder to configure the workspace)
- git add 'files'
- git commit -m 'messgae'
- git status
- git push
- when change happes in git server:
		- Git pull
		- fetch
