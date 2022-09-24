package br.com.lteixeira.msprobe.application.strategy

import br.com.lteixeira.msprobe.application.enumeration.Direction
import br.com.lteixeira.msprobe.domain.AddProbeCommandDomain

class ProbeForwardDirectionStrategyImpl : ProbeDirectionStrategy {
    override fun getDirection(probe: AddProbeCommandDomain): AddProbeCommandDomain {
        var locationX = probe.probeCommandCoordinate!!.locationX
        var locationY = probe.probeCommandCoordinate!!.locationY
        when (probe.direction) {
            Direction.NORTH -> locationY++
            Direction.WEST -> locationX--
            Direction.SOUTH -> locationY--
            Direction.EAST -> locationX++
        }
        probe.probeCommandCoordinate!!.locationX = locationX
        probe.probeCommandCoordinate!!.locationY = locationY
        return probe
    }
}