<html>
<head>
    <title>Branched Game</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
<h1>The Lost Forest</h1>

<!-- Display the introduction or the current step based on the game state -->
<c:choose>

    <c:when test="${gameState == 'intro'}">
        <p> You awaken to the sound of rustling leaves and the faint call of distant birds.
        The surrounding forest is thick, and the path you once walked has disappeared.</p>
        <p> As you rise to your feet, you realize you have two choices:</p>
        <ul>
            <li><a href="game?choice=pathA">A) Venture deeper into the forest, hoping to find a way out.</a></li>
            <li><a href="game?choice=pathB">B) Climb a nearby tree to get a better view of your surroundings.</a></li>
        </ul>
    </c:when>

    <c:when test="${gameState == 'pathA'}">
        <p>Branch 1A: You decide to push forward, navigating through the dense undergrowth.
            After an hour of walking, you come across an old man sitting by a campfire.</p>

        <p>The Old Man says: Many travelers have been lost in these woods.
            You must make a choice, young one. I can offer you a magical map, or you can continue without it.</p>
        <ul>
            <li><a href="game?choice=GoodEndingA">A) Take the magical map.</a></li>
            <li><a href="game?choice=BadEndingA">B) Refuse the map and continue on your own.</a></li>
        </ul>
    </c:when>

    <c:when test="${gameState == 'GoodEndingA'}">
        <p>Branch 1AA: You take the magical map. It glows faintly, showing you a hidden path out of the forest.
            You follow the path and soon find a clearing, leading to safety. You have escaped the forest!</p>
        <p>Ending 1A: (Good Ending)</p>
        <ul>
            <li><a href="game?choice=restart">Restart the Game</a></li>
        </ul>
    </c:when>

    <c:when test="${gameState == 'BadEndingA'}">
        <p>Branch 1AB: You refuse the map, trusting your instincts.
            As you travel deeper into the forest, the trees become darker, the air heavier.
            Soon, you are lost once again. Night falls, and you hear strange sounds approaching from all directions.</p>
        <p>The forest claims you.</p>
        <p>Ending 1B: (Bad Ending)</p>
        <ul>
            <li><a href="game?choice=restart">Restart the Game</a></li>
        </ul>
    </c:when>

    <c:when test="${gameState == 'pathB'}">
        <p>Branch 1B: You climb the tree and spot a narrow trail leading deeper into the forest.
            At the base of the tree, you see a young woman watching you.</p>
        <p>She smiles and beckons you to follow her.</p>
        <ul>
            <li><a href="game?choice=continuePathBA">A) Follow the young woman.</a></li>
            <li><a href="game?choice=GoodEndingBB">B) Ignore her and take the narrow trail you spotted.</a></li>
        </ul>
    </c:when>

    <c:when test="${gameState == 'continuePathBA'}">
        <p>Branch 1BA: You follow the young woman.
            She leads you through hidden passages and shows you secret signs etched into trees.</p>
        <p>Eventually, she reveals that she is a spirit of the forest and offers to guide you to safety in exchange for your loyalty.</p>
        <ul>
            <li><a href="game?choice=NeutralEndingBAA">A) Accept her offer and become her ally.</a></li>
            <li><a href="game?choice=BadEndingBAB">B) Refuse her offer and continue alone.</a></li>
        </ul>
    </c:when>

    <c:when test="${gameState == 'NeutralEndingBAA'}">
        <p>Branch 1BAA: You accept her offer, and the forest begins to feel like home.
            Together, you rule over the trees and creatures as an eternal protector.
            You have become the Guardian of the Lost Forest.</p>
        <p>Ending 2A: (Neutral Ending)</p>
        <ul>
            <li><a href="game?choice=restart">Restart the Game</a></li>
        </ul>
    </c:when>

    <c:when test="${gameState == 'BadEndingBAB'}">
        <p>Branch 1BAB: You refuse her offer, but without her guidance, the forest becomes hostile.
            The trees seem to close in on you, and no matter which way you turn, the path never leads out.</p>
        <p>You remain lost in the forest forever.</p>
        <p>Ending 2B: (Bad Ending)</p>
        <ul>
            <li><a href="game?choice=restart">Restart the Game</a></li>
        </ul>
    </c:when>

    <c:when test="${gameState == 'GoodEndingBB'}">
        <p>Branch 1BB: You take the narrow trail, and after several hours, the dense trees finally begin to thin.
            In the distance, you see the edge of the forest.</p>
        <p>With a last surge of energy, you break free of the woods, stepping into the light of an open field. You have escaped!</p>
        <p>Ending 1A: (Good Ending)</p>
        <ul>
            <li><a href="game?choice=restart">Restart the Game</a></li>
        </ul>
    </c:when>

    <c:otherwise>
        <p>Error: Invalid game state!</p>
    </c:otherwise>
</c:choose>
</body>
</html>