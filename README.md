<!-- Improved compatibility of back to top link: See: https://github.com/othneildrew/Best-README-Template/pull/73 -->
<a id="readme-top"></a>
<!--
*** Thanks for checking out the Best-README-Template. If you have a suggestion
*** that would make this better, please fork the repo and create a pull request
*** or simply open an issue with the tag "enhancement".
*** Don't forget to give the project a star!
*** Thanks again! Now go create something AMAZING! :D
-->



<!-- PROJECT SHIELDS -->
<!--
*** I'm using markdown "reference style" links for readability.
*** Reference links are enclosed in brackets [ ] instead of parentheses ( ).
*** See the bottom of this document for the declaration of the reference variables
*** for contributors-url, forks-url, etc. This is an optional, concise syntax you may use.
*** https://www.markdownguide.org/basic-syntax/#reference-style-links
-->



<!-- PROJECT LOGO -->
<br />
<div align="center">
  <!--
  <a href="https://github.com/github_username/repo_name">
     <img src="images/logo.png" alt="Logo" width="80" height="80"> 
  </a>
  -->
<h3 align="center">Ranged Chat Restriction Plugin for 1.16.5</h3>

  <p align="center">
    近くの人にだけ表示されるチャットプラグイン for 1.16.5
  </p>
  <img src="https://img.shields.io/badge/Minecraft%20Version-1.16.5-00FF00?style=for-the-badge">
  <img src="https://img.shields.io/badge/Plugin Type-Bukkit/Spigot-FF8000?style=for-the-badge">
</div>

<!-- TABLE OF CONTENTS -->




<!-- ABOUT THE PROJECT -->
## About The Project

<!-- [![Product Name Screen Shot][product-screenshot]](https://example.com) -->
This plugin allows to restrict so that only nearby players can see your chat.
You can customize distance, whether spectator players can hear you, etc.
It works when your server wants to play Simple Voice Chat but some of the players cannot speak.
Currently text in the plugin is Japanese only, but it works with English chats, too.

入力したチャットが近くのプレイヤーにしか聞こえないようにするプラグインです。
距離やスペクテイターの表示設定など自由に変更できます。
Simple Voice Chat Mod 等で遊びたいけど聞き専の人がいるときにお勧めです。

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

To use this plugin, you have to do the following:<br />
1. Install 1.16.5 Bukkit/Spigot/Paper(or something like this) server. (Just google how to do it)<br />
2. Put "RangedChat-1.16.5.jar" file in the "plugins" folder.<br />
3. Launch your server and all done!<br />

プラグインの導入方法<br />
1. Bukkit/Spigot/Paper(その他互換性のあるサーバー)を 1.16.5 で立てます。<br />
2. 「RangedChat-1.16.5.jar」ファイルをサーバーフォルダ内の「plugins」フォルダ内に置きます。<br />
3. サーバーを起動すれば完了です。<br />

### Commands
Following are just examples. You can change number and boolean on it. Since the plugin does not save settings, if you want to use multiple times, you should run using command blocks.<br />
以下のコマンド例は一例です。適宜数値などを変更して実行してください。設定は保存されないので連続して使用したい場合はコマンドブロックでの実行をお勧めします。<br />

* info
  ```mcfunction
  /info
  ```
See how to use the plugin.(Japanese only)/ヘルプを表示します。(日本語)

* setdist
  ```mcfunction
  /setdist 5
  ```
Set the distance you can hear your chat./チャットが表示される範囲を指定します。

* setdisty
  ```mcfunction
  /setdisty 3
  ```
Set the distance of height you can hear your chat. Use to prevent from hearing players on different floors./チャットが表示される高さ方向を指定します。複数階層あるマップでのゲームで階層間でのチャットを防ぐのに使えます。

* specreceive
  ```mcfunction
  /specreceive true
  ```
Set whether you can receive every chats when you are spectator./スペクテイターがチャットを常時受け取るか設定します。

* specsend
  ```mcfunction
  /specsend false
  ```
Set whether you can send chats to everyone regardless the distance when you are spectator./スペクテイターのチャットが距離にかかわらず他に聞こえるか設定します。

* targetchat
  ```mcfunction
  /targetchat true
  ```
Set whether you can see who the chat is sent to when you hover your chat./チャットにカーソルを合わせたときにチャット送信対象を表示するか設定します。

* displaytarget
  ```mcfunction
  /displaytarget false
  ```
Set whether game displays who your chat will be sent to on the scoreboard. If other plugins or commands use scoreboard, they won't work well, so you should turn off it./スコアボード欄に送信対象を常時表示するか設定します。他にスコアボード欄を使用するプラグインやコマンドがあると競合するので false にしておきましょう。

* all
  ```mcfunction
  /all Hello, World!
  ```
Send chat to all players./全体にメッセージを送信します。

<!-- LICENSE -->
## License

Distributed under the project_license. See `LICENSE.txt` for more information.

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- CONTACT -->
## Contact

Twitter - [@Serena_DQ11](https://twitter.com/Serena_DQ11)

Project Link: [https://github.com/Serena-Healer/RangedChat](https://github.com/Serena-Healer/RangedChat)

<p align="right">(<a href="#readme-top">back to top</a>)</p>



<!-- ACKNOWLEDGMENTS 
## Acknowledgments

* []()
* []()
* []()

<p align="right">(<a href="#readme-top">back to top</a>)</p>
-->


<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[contributors-shield]: https://img.shields.io/github/contributors/github_username/repo_name.svg?style=for-the-badge
[contributors-url]: https://github.com/github_username/repo_name/graphs/contributors
[forks-shield]: https://img.shields.io/github/forks/github_username/repo_name.svg?style=for-the-badge
[forks-url]: https://github.com/github_username/repo_name/network/members
[stars-shield]: https://img.shields.io/github/stars/github_username/repo_name.svg?style=for-the-badge
[stars-url]: https://github.com/github_username/repo_name/stargazers
[issues-shield]: https://img.shields.io/github/issues/github_username/repo_name.svg?style=for-the-badge
[issues-url]: https://github.com/github_username/repo_name/issues
[license-shield]: https://img.shields.io/github/license/github_username/repo_name.svg?style=for-the-badge
[license-url]: https://github.com/github_username/repo_name/blob/master/LICENSE.txt
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=for-the-badge&logo=linkedin&colorB=555
[linkedin-url]: https://linkedin.com/in/linkedin_username
[product-screenshot]: images/screenshot.png
[Next.js]: https://img.shields.io/badge/next.js-000000?style=for-the-badge&logo=nextdotjs&logoColor=white
[Next-url]: https://nextjs.org/
[React.js]: https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB
[React-url]: https://reactjs.org/
[Vue.js]: https://img.shields.io/badge/Vue.js-35495E?style=for-the-badge&logo=vuedotjs&logoColor=4FC08D
[Vue-url]: https://vuejs.org/
[Angular.io]: https://img.shields.io/badge/Angular-DD0031?style=for-the-badge&logo=angular&logoColor=white
[Angular-url]: https://angular.io/
[Svelte.dev]: https://img.shields.io/badge/Svelte-4A4A55?style=for-the-badge&logo=svelte&logoColor=FF3E00
[Svelte-url]: https://svelte.dev/
[Laravel.com]: https://img.shields.io/badge/Laravel-FF2D20?style=for-the-badge&logo=laravel&logoColor=white
[Laravel-url]: https://laravel.com
[Bootstrap.com]: https://img.shields.io/badge/Bootstrap-563D7C?style=for-the-badge&logo=bootstrap&logoColor=white
[Bootstrap-url]: https://getbootstrap.com
[JQuery.com]: https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white
[JQuery-url]: https://jquery.com 
