# Step1 设计测试用例

请你设计一个计算保龄球比赛一局总得分的程序，保龄球的计分规则如下:
● 每一局总共有十轮，每轮一开始会有十支球瓶，球手可以扔两次球，目标就是用尽量少的球把全部球瓶击倒。
● 如果第一球就把全部的球瓶都击倒了，也就是STRIKE，画面出现“X”，就算完成一轮了，所得分数是10分再加后面两球的倒瓶数。
● 如果第一球没有全倒，就要再打一球，如果第二球将剩下的球瓶全都击倒，也就是SPARE，画面出现“/”，也算完成一格，所得分数为10分再加下一轮第一球的倒瓶数。
● 如果第二球也没有把球瓶全部击倒的话，那分数就是第一球加第二球倒的瓶数，没有奖励(bonus)，再接着打下一轮。依此类推。
● 第十轮有机会扔三次球。如果在第十轮出现STRIKE或者SPARE，则球手可再加打第三球。
● 全部十轮的得分相加就等于这一局的总得分。

我将使用Test-driven development进行开发 ，所以需要先写测试，然后再实现代码。请 给出一份测试列表，列出所有需要实现的功 能。

Sure, based on the rules you've provided, here's a test list for the bowling game program:

1. Test for a perfect game: A perfect game is when in every frame the player gets a strike. The score for a perfect game is 300.
2. Test for a game with all spares: In every frame, the player gets a spare. The score for this game should be 150.
3. Test for a game with 10 strikes and 1 spare: The player gets 10 strikes and 1 spare in the 10 frames. The score for this game should be 260.
4. Test for a game with 10 strikes and 2 spares: The player gets 10 strikes and 2 spares in the 10 frames. The score for this game should be 280.
5. Test for a game with 10 strikes and 3 spares: The player gets 10 strikes and 3 spares in the 10 frames. The score for this game should be 300.

# Step2 给出测试用例顺序

我将使用Test-driven development进行开发 ，请给出测试顺序。

Sure, here's a suggested test order for the bowling game program:

1. Test for a perfect game: Write a test that creates a game with 12 strikes in a row and verifies that the score is 300.
2. Test for a game with all spares: Write a test that creates a game with 10 frames where the player gets a spare in every frame and verifies that the score is 150.
3. Test for a game with 10 strikes and 1 spare: Write a test that creates a game with 10 frames where the player gets 10 strikes and 1 spare and verifies that the score is 260.
4. Test for a game with 10 strikes and 2 spares: Write a test that creates a game with 10 frames where the player gets 10 strikes and 2 spares and verifies that the score is 280. （AI给出的计算结果有错，应该是285）
5. Test for a game with 10 strikes and 3 spares: Write a test that creates a game with 10 frames where the player gets 10 strikes and 3 spares and verifies that the score is 300. （不可能出现这种情况）
6. Test for a game with 10 frames and 3 strikes in the 10th frame: Write a test that creates a game with 10 frames and verifies that the score is 270.（不可能出现这种情况）
7. Test for a game with 11 frames and 3 strikes in the 10th frame and a spare in the 11th frame: Write a test that creates a game with 11 frames and verifies that the score is 280.（不可能出现这种情况）
8. Test for a game with 12 frames and 3 strikes in the 10th frame and 2 spares in the 11th and 12th frames: Write a test that creates a game with 12 frames and verifies that the score is 300.（不可能出现这种情况）

# Step3 设计类图

## Step 3.1

请你设计一个计算保龄球比赛一局总得分的程序，保龄球的计分规则如下:
● 每一局总共有十轮，每轮一开始会有十支球瓶，球手可以扔两次球，目标就是用尽量少的球把全部球瓶击倒。
● 如果第一球就把全部的球瓶都击倒了，也就是STRIKE，画面出现“X”，就算完成一轮了，所得分数是10分再加后面两球的倒
瓶数。
● 如果第一球没有全倒，就要再打一球，如果第二球将剩下的球瓶全都击倒，也就是SPARE，画面出现“/”，也算完成一格，所
得分数为10分再加下一轮第一球的倒瓶数。
● 如果第二球也没有把球瓶全部击倒的话，那分数就是第一球加第二球倒的瓶数，没有奖励(bonus)，再接着打下一轮。依
此类推。
● 第十轮有机会扔三次球。如果在第十轮出现STRIKE或者SPARE，则球手可再加打第三球。
● 全部十轮的得分相加就等于这一局的总得分。

这是要实现的功能。
请根据功能设计出类图，要求符合SOLID、GRASP模 式、Simple Design（XP）。

根据提供的功能，我们可以设计一个类图来满足要求。下面是一个简单的类图设计：

```markdown
classDiagram
    class Game {
        -int totalScore
        +Game()
        +playGame()
        +calculateScore(int[] throws)
    }
    class Round {
        -int score
        +Round(int[] throws)
        +calculateScore()
    }
    class Throw {
        -int score
        +Throw(int[] balls)
        +isStrike()
        +isSpare()
        +calculateScore()
    }
    class Bowl {
        -int balls
        +Owl(int balls)
    }
    Game --> Round
    Round --> Throw
    Round --> Bowl
    Throw --> Bowl
```

—

## Step 3.2

请再次检视你的设计，尝试找到其中的错误和问题，并给出更正确合理的设计。
请画出类图和时序图，使用PlantUML。

非常抱歉，我之前的设计有误。根据提供的功能，我们可以进行以下更正：

类图：

```markdown

classDiagram
    class Game {
        -int totalScore
        +Game()
        +playGame()
        +calculateScore(int[] throws)
    }
    class Round {
        -int score
        +Round(int[] throws)
        +calculateScore()
    }
    class Throw {
        -int score
        +Throw(int[] balls, int[] pins)
        +isStrike()
        +isSpare()
        +calculateScore()
    }
    class Bowl {
        -int balls
        -int pins
        +Bowl(int balls, int pins)
    }
    Game --> Round
    Round --> Throw
    Round --> Bowl

```

时序图：

```markdown
CopyInsert
sequenceDiagram
    participant game as Game
    participant round as Round
    participant throw as Throw
    participant bowl as Bowl

    game->>game: playGame()
    game->>round: new Round(throws)
    round->>round: calculateScore()
    round->>throw: new Throw(balls, pins)
    throw->>throw: isStrike()
    throw->>throw: isSpare()
    throw->>throw: calculateScore()
    throw->>bowl: new Bowl(balls, pins)

```

这个设计更加符合要求，包括类之间的关系和方法的调用。

# Step 4 写出测试

写第一个测试: Test for a perfect game: Write a test that creates a game with 12 strikes in a row and verifies that the score is 300。

请 写出测试用例，使用Java、Junit 5。

当然，我可以帮你编写一个测试用例来验证一整局保龄球的得分是否为300分。

下面是使用Java和JUnit 5编写的测试用例：

```java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GameTest {

    @Test
    void testPerfectGame() {
        // Arrange
        int[] throwsArray = new int[12];
        for (int i = 0; i < throwsArray.length; i++) {
            throwsArray[i] = 10; // 10 represents a strike
        }

        Game game = new Game();

        // Act
        int score = game.calculateScore(throwsArray);

        // Assert
        assertEquals(300, score);
    }

}

```

这个测试用例创建了一个保龄球游戏，并使用一个包含12个10的数组来模拟12个连续的STRIKE。然后，它调用**`calculateScore`**方法来计算游戏的得分，并使用**`assertEquals`**断言来验证得分是否为300。

你可以将这个测试用例添加到你的测试类中，并使用JUnit 5来运行它。如果测试通过，则说明保龄球游戏的得分计算正确。

# Step 5 写实现

写实现的时候 Code Completion 模式不好用，不管我给什么注释，总给我一个“return 0”。

我就转到chat模式中，给出的实现也是不对的，自己根据实际情况进行修改让测试通过。

# 纠正AI给的错误的测试用例

1. Test for a perfect game with all strikes: 10 strikes in a row, and both 11th & 12th throws show 10 pins down, the score is 300.
    1. xxxxx xxxxx xx
    2. 10*(10+10*2) = 300
2. Test for a game with all spares: 10 frames where the player gets a spare in every frame, and every throw shows 5 pins down, also 12th throw shows 5 pins down, the score is 150.
    1. // // // // // // // // //   //*
    2. 9*(10+5) + (5+5+5) = 9*15 + 15 = 150
3. 第11次和第12次等于10个瓶： Test for a game with 10 strikes and 1 spare: Write a test that creates a game with 10 frames where the player gets 10 strikes and 1 spare and verifies that the score is 260.
    1. 用词有问题，应该是10个strikes, 10th frame后面2次扔球一共打到少于10个球瓶
    2. xxxxx xxxx x**，如果**分别是8和2
    3. 8*(10+10*2) + (10+10+8) + (10+8+2) = 240 + 28 + 20 = 288

4. 第11次和第12次少于10个瓶：Test for a game with 10 strikes and 2 spares: Write a test that creates a game with 10 frames where the player gets 10 strikes and 2 spares and verifies that the score is 280. （AI给出的计算结果有错，应该是285）
    1. 用词有问题，应该是10个strikes, 10th frame后面2次扔球一共打到10个球瓶
    2. xxxxx xxxx x**，如果**是8和0
    3. 8*(10+10*2) + (10+10+8) + (10+8+0) = 240 + 28 + 18 = 186

### 重新设计测试用例:

做完第4个 Case以后发现AI给的不对，重新计算检查，重新设计测试用例。

AI 设计的数据结构有些问题，重新设计数据结构。

- 每局都是Strike
    - xxxxx xxxxx xx
    - 10*(10+10*2) = 300
    - 总局数*(Strike score + next_throw + next_next_throw)
    - TOTAL_FRAMES*(STRIKE_SCORE + next_throw + next_next_throw)
    - 单次strike计算方式：STRIKE_SCORE + next_throw + next_next_throw
- 每局都是Spare, 比如每局的每个投球都击倒5瓶
    - // // // // // // // // //   //*
    - 9*(10+5) + (5+5+5) = 9*15 + 15 = 150
    - (TOTAL_FRAMES-1)*SPARE_SCORE + (SPARE_SCORE+next_throw)
    - 单次spare计算方式： SPARE_SCORE + next_throw
- (增加一个case)不是每局都是Strike，其中一个Strike后面不是Strike
    - xxxxx xxx(4-5)x xx
    - 6 * (10+20) + (10+10+4) + (10+4+5)+(4+5) + 30 = 180+24+19+9+30=210+52=262
    - 总局数*(Strike score + next_throw + next_next_throw)
    - TOTAL_FRAMES*(STRIKE_SCORE + next_throw + next_next_throw)
    - 单次strike计算方式：STRIKE_SCORE + next_throw + next_next_throw
- （case最简单，应该第一个做这个case)每局都没有奖励，都不是Strike or Spare，比如每局每个投球都击倒4瓶。注意：第10局只有2次投球。
    - 44 44 44 44 44     44 44 44 44 44
    - 10*(4+4) = 80
    - TOTAL_FRAMES * (current_throw + next_throw)
    - 单次普通（没有奖励计算方式）：current_throw
- 一些是Strike， 一些是Spare, 一些是没有奖励的。注意：第10局只有2次投球。
    - xxxxx // // // 44 44
    - 3*30 + (10+10+5) + (10+5+5) + (10+5)*2 + (10+4)+2*8 = 90+25+20+30+14+16=165+30=195
    - isStrike: STRIKE_SCORE + next_throw + next_next_throw
    - isSpare: SPARE_SCORE + next_throw
    - isNormal: current_throw


# 反思

开始使用的工具： VS Code + Codeium

后面切换为：IntelliJ Idea + Github Copilot

### 发现：

- 测试用例的设计可能是错误的
- 类和数据结构的设计可能并不能满足后续的开发
- AI 工具根据测试给出实现代码还不好，完成实现代码的过程中基本没用到他的帮助
- 习惯了使用IntelliJ Idea 开发Java程序，使用VS code感觉体验就差了点，可能是还没用对。比如想要通过日志查看结果的时候，测试运行后不输出

### 思考：

当我相信了AI，AI给出的东西对不对就不是AI的问题了，就是我的问题了。

当第一次拿到AI的结果的时候我并没有认真的去看他给的结果是否正确，一味地相信了AI的投喂。

直到后面做了一大半才发现大部分都是错的，而且测试用例的设计以及类和数据结构的设计上都不能满足后续的开发。

AI只是辅助，正确方式是我先自己设计完，然后用AI辅助产生对应的test case。 切记一定要知道AI给的东西是什么，展示出火眼金睛。