<?xml version="1.0" standalone="yes"?>
<ServiceRequest xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:m='urn:messages.service.ti.apps.tiplus2.misys.com' xmlns:c='urn:common.service.ti.apps.tiplus2.misys.com' xmlns='urn:control.services.tiplus2.misys.com'>
	<RequestHeader>
		<Service>TI</Service>
		<Operation>${actionCode}</Operation>
		<Credentials>
			<Name>SUPERVISOR</Name>
			<Password>Password</Password>
			<Certificate>Certificate</Certificate>
			<Digest>Digest</Digest>
		</Credentials>
		<ReplyFormat>FULL</ReplyFormat>
		<ReplyTarget>ReplyTarget</ReplyTarget>
		<TargetSystem>ZONE2</TargetSystem>
		<SourceSystem>API</SourceSystem>
		<NoRepair>Y</NoRepair>
		<NoOverride>Y</NoOverride>
		<CorrelationId>${correlationId}</CorrelationId>
		<TransactionControl>NONE</TransactionControl>
	</RequestHeader>
	<m:RetrieveMasterDetailRequest>
		<m:DefinitionID>ORMLOOKUP</m:DefinitionID>
		<m:MasterReference>
			<c:BehalfOfBranch>CITY</c:BehalfOfBranch>
			<c:Reference>${masterReferenceId}</c:Reference>
		</m:MasterReference>
	</m:RetrieveMasterDetailRequest>
</ServiceRequest>