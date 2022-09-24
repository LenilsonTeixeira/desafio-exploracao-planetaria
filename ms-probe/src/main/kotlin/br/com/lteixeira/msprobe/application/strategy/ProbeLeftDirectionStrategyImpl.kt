package br.com.lteixeira.msprobe.application.strategy

import br.com.lteixeira.msprobe.application.enumeration.Direction
import br.com.lteixeira.msprobe.domain.AddProbeCommandDomain

class ProbeLeftDirectionStrategyImpl : ProbeDirectionStrategy {
    override fun getDirection(probe: AddProbeCommandDomain): AddProbeCommandDomain {
        val newDirection = when (probe.direction) {
            Direction.NORTH -> Direction.WEST
            Direction.WEST -> Direction.SOUTH
            Direction.SOUTH -> Direction.EAST
            Direction.EAST -> Direction.NORTH
        }
        probe.direction = newDirection
        return probe
    }
}