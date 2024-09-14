package com.singularitycoder.learnit.helpers.konfetti

import com.singularitycoder.learnit.helpers.konfetti.core.Angle
import com.singularitycoder.learnit.helpers.konfetti.core.Party
import com.singularitycoder.learnit.helpers.konfetti.core.Position
import com.singularitycoder.learnit.helpers.konfetti.core.Rotation
import com.singularitycoder.learnit.helpers.konfetti.core.Spread
import com.singularitycoder.learnit.helpers.konfetti.core.emitter.Emitter
import com.singularitycoder.learnit.helpers.konfetti.core.models.Shape
import com.singularitycoder.learnit.helpers.konfetti.core.models.Size
import java.util.concurrent.TimeUnit

class Presets {

    companion object {
        private val colors1 = listOf(0xfce18a, 0xff726d, 0xf4306d, 0xb48def)
        private val colors2 = listOf(0xD1C4E9, 0xBB86FC, 0x9575CD, 0x6200EE, 0x3700B3)
        fun festive(drawable: Shape.DrawableShape? = null): List<Party> {
            val party = Party(
                speed = 30f,
                maxSpeed = 50f,
                damping = 0.9f,
                angle = Angle.TOP,
                spread = 45,
                size = listOf(Size.SMALL, Size.LARGE, Size.LARGE),
                shapes = listOf(Shape.Square, Shape.Circle, drawable).filterNotNull(),
                timeToLive = 3000L,
                rotation = Rotation(),
                colors = colors2,
                emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(30),
                position = Position.Relative(0.5, 1.0)
            )

            return listOf(
                party,
                party.copy(
                    speed = 55f,
                    maxSpeed = 65f,
                    spread = 10,
                    emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(10),
                ),
                party.copy(
                    speed = 50f,
                    maxSpeed = 60f,
                    spread = 120,
                    emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(40),
                ),
                party.copy(
                    speed = 65f,
                    maxSpeed = 80f,
                    spread = 10,
                    emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(10),
                )
            )
        }

        fun explode(): List<Party> {
            return listOf(
                Party(
                    speed = 0f,
                    maxSpeed = 30f,
                    damping = 0.9f,
                    spread = 360,
                    colors = colors2,
                    emitter = Emitter(duration = 100, TimeUnit.MILLISECONDS).max(100),
                    position = Position.Relative(0.5, 0.3)
                )
            )
        }

        fun parade(): List<Party> {
            val party = Party(
                speed = 10f,
                maxSpeed = 30f,
                damping = 0.9f,
                angle = Angle.RIGHT - 45,
                spread = Spread.SMALL,
                colors = colors2,
                emitter = Emitter(duration = 5, TimeUnit.SECONDS).perSecond(30),
                position = Position.Relative(0.0, 0.5)
            )

            return listOf(
                party,
                party.copy(
                    angle = party.angle - 90, // flip angle from right to left
                    position = Position.Relative(1.0, 0.5)
                ),
            )
        }

        fun rain(): List<Party> {
            return listOf(
                Party(
                    speed = 0f,
                    maxSpeed = 15f,
                    damping = 0.9f,
                    angle = Angle.BOTTOM,
                    spread = Spread.ROUND,
                    colors = colors2,
                    emitter = Emitter(duration = 5, TimeUnit.SECONDS).perSecond(100),
                    position = Position.Relative(0.0, 0.0).between(Position.Relative(1.0, 0.0))
                )
            )
        }
    }
}
