package br.com.lteixeira.msprobe.application.strategy

import br.com.lteixeira.msprobe.application.enumeration.Direction
import br.com.lteixeira.msprobe.domain.AddProbeCommandDomain

class ProbeRightDirectionStrategyImpl : ProbeDirectionStrategy {
    override fun getDirection(probe: AddProbeCommandDomain): AddProbeCommandDomain {
        val newDirection = when (probe.direction) {
            Direction.NORTH -> Direction.EAST
            Direction.EAST -> Direction.SOUTH
            Direction.SOUTH -> Direction.WEST
            Direction.WEST -> Direction.NORTH
        }
        probe.direction = newDirection
        return probe
    }
}