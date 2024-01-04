import { Avatar, Box } from "@mui/material";
import {useFormContext} from "react-hook-form";

const RegistrationFormAvatar = () => {
  const { control, watch } = useFormContext()
  const initial = watch(["firstname", "lastname", "patronymic"])
    .filter(value => !!value)
    .at(0)
    ?.[0]
    ?.toUpperCase()
  return (
    <Box className={"flex h-42 justify-center items-center"}>
      <Avatar className={"h-36 w-36"}>
        {initial}
      </Avatar>
    </Box>
  )
}

export default RegistrationFormAvatar
